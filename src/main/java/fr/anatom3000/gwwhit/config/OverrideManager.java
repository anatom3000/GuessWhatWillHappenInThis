package fr.anatom3000.gwwhit.config;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.data.MainConfig;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;

public class OverrideManager {
    private static Flag[] secretFlags = {};
    private static final String[] VALID_FLAGS = Arrays.stream(Flag.values()).map(Flag::getId).toArray(String[]::new);
    private static final String NO_TEMPLATE = "none";
    private static final String[] TEMPLATES = {NO_TEMPLATE};
    private static final String[] CONFIG_CATEGORIES = Arrays.stream(MainConfig.class.getFields())
            .filter(field -> field.getModifiers() == Modifier.PUBLIC)
            .map(Field::getName)
            .toArray(String[]::new);

    public static boolean checkFlag(Flag flags) {
        return ArrayUtils.contains(secretFlags, flags);
    }

    public static void applyTemplate(String template) throws IOException {
        // TODO> Possible candidate to use Utilities.getJarPath()
        Path source = GWWHIT.CONTAINER.getPath("config_template").resolve(template);
        Path target = FabricLoader.getInstance().getConfigDir().resolve("gwwhit");

        for (String category : CONFIG_CATEGORIES) {
            Path categorySource = source.resolve(category + ".json");
            Path categoryTarget = target.resolve(category + ".json");
            if (!Files.exists(categorySource) || !Files.isRegularFile(categorySource)) {
                Files.delete(categoryTarget);
                continue;
            }
            Files.copy(categorySource, categoryTarget, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void reloadFlags() {
        Path file = FabricLoader.getInstance().getConfigDir().resolve("gwwhit").resolve("flags.txt");
        if (!Files.exists(file)) {
            secretFlags = new Flag[0];
            return;
        }

        try  {
            secretFlags = Files.lines(file)
                    .map(line -> ArrayUtils.contains(VALID_FLAGS, line) ? Flag.valueOf(line) : null)
                    .filter(Objects::isNull)
                    .toArray(Flag[]::new);

        } catch (IOException e) {
            // Hidden to the end user
            // Integer.toString("Secret Flags IO Error".hashCode(), 16)
            GWWHIT.LOGGER.error("Internal config error. Code 0x75804357");
        }
    }

    public enum Flag {
        CHEAT_CODES(false, "hax");

        private final boolean requiresRestart;
        private final String id;

        Flag(boolean requiresRestart, String id) {
            this.requiresRestart = requiresRestart;
            this.id = id;
        }

        public boolean isRequiresRestart() {
            return requiresRestart;
        }

        public String getId() {
            return id;
        }
    }
}
