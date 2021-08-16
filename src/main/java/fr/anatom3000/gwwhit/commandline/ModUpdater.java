package fr.anatom3000.gwwhit.commandline;

import com.google.gson.*;
import fr.anatom3000.gwwhit.util.Utilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/* IMPORTANT: This is run in a command line context, where we don't have minecraft or it's libs!
   Try avoiding the use of libs (eg. use CommandLine instead of a LOGGER)
   We are using the gradle shadow plugin to include gson in the mod
   We must also make sure we don't access a class that uses any mc libs since that will fail to load
*/
public class ModUpdater {
    private static final URL VERSIONS_URL;
    private static final Path MOD_FOLDER = Path.of("").toAbsolutePath();
    public static final Gson GSON = new GsonBuilder().create();
    private static String[] args;
    
    static {
        URL url;
        try {
            url = new URL("https://api.modrinth.com/api/v1/mod/mUOQM1cd/version");
        } catch (MalformedURLException e) {
            throw new IllegalStateException("<clr:red>Internal url is invalid!", e);
        }
        VERSIONS_URL = url;
    
    }
    
    public static void main(String[] args) {
        ModUpdater.args = args;
        try {
            new ModUpdater().update();
        } catch (Throwable e) {
            CommandLine.println("<clr:red>An error occurred");
            if (Utilities.contains(args, "--debug")) {
                e.printStackTrace();
            } else {
                CommandLine.println("Use --debug for more info");
            }
        }
    }
    
    private void update() {
        if (! Utilities.contains(args, "--force") ) {
            CommandLine.println("If a malicious actor has accessed the mods page the jar could be compromised.");
            switch (CommandLine.prompt("<clr:blue>Are you sure you want to download the latest jar? Y/N: ").toLowerCase()) {
                case "y", "yes":
                    break;
                default:
                    CommandLine.println("<clr:red>Invalid input. Exiting...");
                case "n", "no":
                    return;
            }
        }
        
        
        CommandLine.println("Searching for newer versions...");
        VersionData versionData;
        try {
            versionData = getDownloadData();
        } catch (IOException e) {
            CommandLine.println("<clr:red>Can't get download url!");
            e.printStackTrace();
            return;
        }
    
        CommandLine.println("Searching for current jar...");
        Pair<File, VersionData.VersionNumber> data = getModJar();
        File modJar = data.a();
        if (modJar == null) {
            CommandLine.println( "<clr:red>Can't find current jar at " + MOD_FOLDER + "! Has the mod id changed?" );
        }
        CommandLine.println("Current jar located at " + modJar + "!");
        
        if (versionData == null) {
            CommandLine.println("<clr:red>Can't get version data!");
            return;
        }
        
        if (! Utilities.contains(args, "--always") && versionData.number().compareTo(data.b() ) < 0 ) {
            CommandLine.println("<clr:green>No newer versions found!");
            return;
        }
        CommandLine.println( "<clr:green>Found newer version " + versionData.number() + "! Current: " + data.b );
        
        CommandLine.println( "Downloading " + versionData.filename() + "..." );
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(versionData.createURL().openStream())) {
            FileOutputStream fileOutputStream = new FileOutputStream(
                    MOD_FOLDER.resolve(
                            versionData.filename()
                    ).toFile()
            );
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            CommandLine.println("<clr:red>Failed to download new jar!");
            return;
        }
        CommandLine.println( "Downloaded to " + MOD_FOLDER.resolve( versionData.filename() ) );
    
        if (modJar == null) return;
        try {
            Files.delete(modJar.toPath());
            CommandLine.println("Deleted " + modJar + '!');
        } catch (IOException e) {
            CommandLine.println("<clr:red>Failed to delete " + modJar + "! Please remove it manually!");
        }
    }
    
    private Pair<File, VersionData.VersionNumber> getModJar() {
        File gwwhit;
        try {
            gwwhit = Utilities.getJarLocation().toFile();
        } catch (URISyntaxException e) {
            CommandLine.println("<clr:red>Somehow the URL class returned a bad URI.");
            throw new IllegalStateException("WTF", e);
        }
        VersionData.VersionNumber number = new VersionData.VersionNumber(
            GSON.fromJson(
                new BufferedReader(
                    new InputStreamReader(
                            Objects.requireNonNull(
                                    Utilities.getResource("fabric.mod.json")
                            )
                    )
                ),
                JsonObject.class
            ).get("version").getAsString()
        );

        return new Pair<>(gwwhit, number);
    }
    
    private VersionData getDownloadData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(VERSIONS_URL.openStream()));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        while (line != null) {
            sb.append( line.replace("\n", "") );
            line = br.readLine();
        }
        
        JsonArray versions;
        try {
            versions = GSON.fromJson(sb.toString(), JsonArray.class);
        } catch (JsonParseException e) {
            throw new IOException(e);
        }
        if (versions == null)
            throw new IOException("Something went wrong with parsing versions!");
    
        List<VersionData> data = new ArrayList<>();
        
        for (JsonElement element : versions) {
            if (! (element instanceof JsonObject object) )
                throw new IOException("Something went wrong with parsing versions!");
            data.add( new VersionData(object) );
        }
        Collections.sort(data);
        
        if ( data.isEmpty() )
            return null;
        return data.get( data.size() - 1 );
    }
    
    private record Pair<A, B>(A a, B b) {}
}
