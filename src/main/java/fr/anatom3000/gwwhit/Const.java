package fr.anatom3000.gwwhit;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fr.anatom3000.gwwhit.util.SafeUtils;
import fr.anatom3000.gwwhit.util.Utilities;
import org.jetbrains.annotations.NotNull;

import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Const {
    public static final String MOD_ID = "gwwhit";
    public static final String MOD_VERSION;
    public static final String MOD_VERSION_CODENAME;
    public static final @NotNull Path ASSETS_ROOT;

    static {
        var data = new GsonBuilder()
                .create()
                .fromJson( new InputStreamReader( Utilities.getResource("fabric.mod.json") ), JsonObject.class );
        MOD_VERSION = data.get("version").getAsString();
        MOD_VERSION_CODENAME = data.get("custom").getAsJsonObject().get("codename").getAsString();
        //noinspection ConstantConditions
        ASSETS_ROOT = SafeUtils.doSafely( () -> Paths.get( Utilities.getResourceURL("assets/gwwhit").toURI() ) );
    }
}
