package fr.anatom3000.gwwhit.updater;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public record VersionData(Type type, VersionNumber number, String url, String filename) implements Comparable<VersionData> {
    public VersionData(JsonObject object) {
        this(Type.get(object.get("version_type").getAsString()),
                new VersionNumber(object.get("version_number").getAsString()),
                object.get("files").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString(),
                object.get("files").getAsJsonArray().get(0).getAsJsonObject().get("filename").getAsString()
        );
        
    }
    
    public URL createURL() throws MalformedURLException {
        return new URL(url);
    }
    
    @Override
    public int compareTo(@NotNull VersionData that) {
        if (that.type != this.type) {
            return this.type.index - that.type.index;
        }
        
        return this.number.compareTo(that.number());
    }
    
    public enum Type {
        RELEASE(3, "release"),
        BETA(2, "beta"),
        ALPHA(1, "alpha"),
        NONE(-1, "invalid");
        
        public final int index;
        public final String name;
        
        Type(int index, String name) {
            this.index = index;
            this.name = name;
        }
        
        @NotNull
        public static Type get(String s) {
            for (Type t : Type.values()) {
                if (t.name.equals(s)) return t;
            }
            return NONE;
        }
    }
    
    public record VersionNumber(int[] parts) implements Comparable<VersionNumber> {
        public VersionNumber(String s) {
            this(Arrays.stream(s.split("\\.")).mapToInt(Integer::parseInt).toArray());
        }
        
        @Override
        public int compareTo(@NotNull VersionNumber that) {
            int sharedLength = Math.min(this.parts.length, that.parts.length);
            
            for (int i = 0; i < sharedLength; i++) {
                int diff = this.parts[i] - that.parts[i];
                if (diff == 0) continue;
                return diff;
            }
            
            return this.parts.length - that.parts.length;
        }
    }
}
