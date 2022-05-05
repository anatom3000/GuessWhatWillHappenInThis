package fr.anatom3000.gwwhit;

import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.MiscConfig;
import fr.anatom3000.gwwhit.util.Utilities;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.IOUtils;
import org.python.core.PyCode;
import org.python.util.PythonInterpreter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author ENDERZOMBI102 and MattiDragon
 */
public class Python {
    private static final String CODE;
    private static final Map<Script, PyCode> SCRIPTS = new HashMap<>();
    private static final Map<Script, Script[]> SCRIPT_GROUPS = new HashMap<>();

    static {
        String code = "";
        try (InputStream stream = Utilities.getResource("/init.py")) {
            code = IOUtils.toString(
                    Objects.requireNonNull(stream),
                    StandardCharsets.UTF_8
            );
        } catch (IOException | NullPointerException e) {
            GWWHIT.LOGGER.error("Error with internal python", e);
        }
        CODE = code;
    }

    public static void load() {
        MiscConfig config = ConfigManager.getActiveConfig().misc;

        if (!(config.python || config.scripting)) return;
        try (PythonInterpreter python = createInterpreter()) {
            if (config.python) python.exec(CODE);
            if (config.scripting) {
                parseScripts(python);
                if (SCRIPT_GROUPS.containsKey(new Script("init.json"))) {
                    try {
                        execute(new Script("init.json"));
                    } catch (RuntimeException e) {
                        GWWHIT.LOGGER.error("Error while executing startup scripts!", e);
                    }
                }
            }
        } catch (Exception e) {
            GWWHIT.LOGGER.error("Error while executing scripts!", e);
        }
    }

    public static List<Script> getKeys() {
        List<Script> list = new ArrayList<>();

        list.addAll(SCRIPT_GROUPS.keySet());
        list.addAll(SCRIPTS.keySet());

        return list;
    }

    public static void execute(Script script) throws RuntimeException {
        if (script.id().endsWith(".json")) {
            RuntimeException problem = null;
            Script[] scripts = SCRIPT_GROUPS.get(script);
            if (scripts == null) {
                problem = new RuntimeException("No script group with name " + script.id());
            } else {
                for (Script script2 : scripts) {
                    try {
                        execute(script2);
                    } catch (Exception e) {
                        if (problem == null) problem = new RuntimeException("Failed to execute one or more scripts!");
                        problem.addSuppressed(e);
                    }
                }
            }
            if (problem != null) {
                throw problem;
            }
        } else if (script.id().endsWith(".py")) {
            try (var interpreter = createInterpreter()) {
                PyCode code = SCRIPTS.get(script);
                if (code == null) throw new RuntimeException("No script with name " + script.id());
                interpreter.exec(code);
            }
        } else {
            throw new RuntimeException(script.id() + " isn't a script or script group");
        }
    }

    private static PythonInterpreter createInterpreter() {
        PythonInterpreter python = new PythonInterpreter();
        python.setErr(System.err);
        python.setOut(System.out);
        python.setIn(System.in);
        return python;
    }

    private static void parseScripts(PythonInterpreter python) {
        Path scriptsPath = FabricLoader.getInstance().getGameDir().resolve("gwwhit/scripts");
        if (!scriptsPath.toFile().exists()) return;
        Map<String, Exception> problems = new HashMap<>();

        try (Stream<Path> files = Files.walk(scriptsPath)) {
            files.forEach(path -> {
                File file = path.toFile();
                String name = scriptsPath.relativize(path).toString();
                try {
                    if (file.getName().endsWith(".json")) {
                        try {
                            JsonArray array = GWWHIT.GSON.fromJson(new FileReader(file), JsonArray.class);
                            Script[] scripts = new Script[array.size()];

                            for (int i = 0; i < array.size(); i++) {
                                scripts[i] = new Script(array.get(i).getAsString().replace('/', '\\'));
                            }

                            SCRIPT_GROUPS.put(new Script(name), scripts);

                        } catch (JsonParseException e) {
                            throw new RuntimeException("Expected .json file to be valid!", e);
                        }
                    }
                    if (file.getName().endsWith(".py")) {
                        SCRIPTS.put(new Script(name), python.compile(Files.readString(path), name));
                    }
                } catch (Exception e) {
                    problems.put(name, e);
                }
            });
        } catch (IOException e) {
            problems.put("root folder", e);
        }

        if (!problems.isEmpty()) GWWHIT.LOGGER.error("Error(s) happened while loading scripts!");
        for (Map.Entry<String, Exception> entry : problems.entrySet()) {
            GWWHIT.LOGGER.error("Error loading file " + entry.getKey(), entry.getValue());
        }
    }

    public record Script(String id) { }
}
