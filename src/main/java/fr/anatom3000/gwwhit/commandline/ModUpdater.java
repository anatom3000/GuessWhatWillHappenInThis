package fr.anatom3000.gwwhit.commandline;

import com.google.gson.*;
import fr.anatom3000.gwwhit.util.SafeUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* IMPORTANT: This is run in a command line context, where we don't have minecraft, and it's libs!
   Try avoiding the use of libs (e.g. use System.out instead of a LOGGER)
   We are using the gradle shadow plugin to include gson in the mod
   We must also make sure we don't access a class that uses any mc libs since that will fail to load
*/
public class ModUpdater {
    public static final Gson GSON = new GsonBuilder().create();
    private static final URL VERSIONS_URL = SafeUtils.doSafely(() -> new URL("https://api.modrinth.com/api/v1/mod/mUOQM1cd/version"));
    private static final Path MOD_FOLDER = Path.of("").toAbsolutePath();
    private static final Scanner IN = new Scanner(new InputStreamReader(System.in));
    private static final String MOD_ID = "gwwhit"; //We can't load the main file since mc isn't active
    private static String[] args;

    public static void main(String[] args) {
        ModUpdater.args = args;
        try {
            if (!CommandLine.contains(args, "--force")) {
                System.out.println("If a malicious actor has accessed the mods page the jar could be compromised.");
                switch (prompt("Are you sure you want to download the latest jar? Y/N: ").toLowerCase()) {
                    case "y", "yes":
                        break;
                    default:
                        System.out.println("Invalid input. Exiting...");
                    case "n", "no":
                        return;
                }
            }
            new ModUpdater().update();
        } catch (Throwable e) {
            System.out.println("An error occurred");
            if (CommandLine.contains(args, "--debug")) {
                e.printStackTrace();
            } else {
                System.out.println("Use --debug for more info");
            }
        }
    }

    private void update() {
        System.out.println("Searching for newer versions...");
        VersionData versionData;
        try {
            versionData = getDownloadData();
        } catch (IOException e) {
            System.out.println("Can't get download url!");
            e.printStackTrace();
            return;
        }

        System.out.println("Searching for current jar...");
        Pair<File, VersionData.VersionNumber> data = getModJar();
        File modJar = data.a();
        if (modJar == null) {
            System.out.println("Can't find current jar at " + MOD_FOLDER + "! Has the mod id changed?");
        }
        System.out.println("Current jar located at " + modJar + "!");

        if (versionData == null) {
            System.out.println("Can't get version data!");
            return;
        }

        if (!CommandLine.contains(args, "--always") && versionData.number().compareTo(data.b()) < 0) {
            System.out.println("No newer versions found!");
            return;
        }
        System.out.println("Found newer version " + versionData.number() + "! Current: " + data.b);

        System.out.println("Downloading " + versionData.filename() + "...");
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(versionData.createURL().openStream())) {
            FileOutputStream fileOutputStream = new FileOutputStream(MOD_FOLDER.resolve(versionData.filename()).toFile());
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            System.out.println("Failed to download new jar!");
            return;
        }
        System.out.println("Downloaded to " + MOD_FOLDER.resolve(versionData.filename()));

        if (modJar == null) return;
        try {
            Files.delete(modJar.toPath());
            System.out.println("Deleted " + modJar + '!');
        } catch (IOException e) {
            System.out.println("Failed to delete " + modJar + "! Please remove it manually!");
        }
    }

    private Pair<File, VersionData.VersionNumber> getModJar() {
        File[] files = MOD_FOLDER.toFile().listFiles((dir, name) -> name.endsWith(".jar"));

        if (files == null) throw new IllegalStateException("Mods folder (" + MOD_FOLDER + ") is a file or empty!");
        File gwwhit = null;
        VersionData.VersionNumber number = null;

        for (File file : files) {
            try {
                JarFile jar = new JarFile(file);
                JarEntry entry = jar.getJarEntry("fabric.mod.json");
                if (entry == null) continue;

                JsonObject object = GSON.fromJson(new InputStreamReader(jar.getInputStream(entry)), JsonObject.class);

                String id = object.get("id").getAsString();
                String version = object.get("version").getAsString();

                if (id.equals(MOD_ID)) {
                    gwwhit = file;
                    number = new VersionData.VersionNumber(version);
                    break;
                }

            } catch (IOException | JsonParseException e) {
                System.out.println("Failed to search a file");
                e.printStackTrace();
            }
        }
        return new Pair<>(gwwhit, number);
    }

    private VersionData getDownloadData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(VERSIONS_URL.openStream()));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while (line != null) {
            sb.append(line.replace("\n", ""));
            line = br.readLine();
        }

        JsonArray versions;
        try {
            versions = GSON.fromJson(sb.toString(), JsonArray.class);
        } catch (JsonParseException e) {
            throw new IOException(e);
        }
        if (versions == null) throw new IOException("Something went wrong with parsing versions!");

        List<VersionData> data = new ArrayList<>();

        for (JsonElement element : versions) {
            if (!(element instanceof JsonObject object))
                throw new IOException("Something went wrong with parsing versions!");
            data.add(new VersionData(object));
        }
        Collections.sort(data);

        if (data.isEmpty()) return null;
        return data.get(data.size() - 1);
    }

    private static String prompt(String message) {
        System.out.print(message);
        return IN.nextLine();
    }

    private record Pair<A, B>(A a, B b) {
    }
}
