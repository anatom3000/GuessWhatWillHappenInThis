package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.config.ConfigManager;
import org.apache.commons.io.IOUtils;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author ENDERZOMBI102
 */
public class Python {
    private static String CODE = "";

    static {
        try (InputStream stream = Python.class.getClassLoader().getResourceAsStream("init.py")) {
            CODE = IOUtils.toString(
                    Objects.requireNonNull(stream),
                    StandardCharsets.UTF_8
            );
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        if (!ConfigManager.getLoadedConfig().content.python) return;
        try (PythonInterpreter python = new PythonInterpreter()) {
            python.setErr(System.err);
            python.setOut(System.out);
            python.exec(CODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
