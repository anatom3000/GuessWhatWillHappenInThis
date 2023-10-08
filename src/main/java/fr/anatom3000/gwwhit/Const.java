package fr.anatom3000.gwwhit;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class Const {
    public static final String MOD_ID = "gwwhit";
    public static final String MOD_VERSION;
    public static final String MOD_VERSION_CODENAME;
    public static final @NotNull Path ASSETS_ROOT;

    static {
        ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID).get();
        MOD_VERSION = container.getMetadata().getVersion().getFriendlyString();
        MOD_VERSION_CODENAME = container.getMetadata().getCustomValue("codename").getAsString();
        Path treeStraw = null;
        for (Path path : container.getRootPaths()) {
        	try {
                treeStraw = path.resolve("assets/gwwhit");
                break;
        	} catch (Exception e) {
        	}
        }
        ASSETS_ROOT = treeStraw;
    }
}
