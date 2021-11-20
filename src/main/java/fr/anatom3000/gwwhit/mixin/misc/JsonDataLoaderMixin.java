package fr.anatom3000.gwwhit.mixin.misc;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import me.shedaniel.cloth.clothconfig.shadowed.org.yaml.snakeyaml.Yaml;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.util.JsonHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.Reader;
import java.util.function.Predicate;

@Mixin(JsonDataLoader.class)
public class JsonDataLoaderMixin {
    private static final String[] gwwhit$ALLOWED_SUFFIXES = {".json", ".yaml", ".yml"};
    private static final String[] gwwhit$YAML_SUFFIXES = {".yaml", ".yml"};
    private String currentSuffix;

    @ModifyArg(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Ljava/util/Map;",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/resource/ResourceManager;findResources(Ljava/lang/String;Ljava/util/function/Predicate;)Ljava/util/Collection;"))
    private Predicate<String> modifyArg(Predicate<String> original) {
        return path -> {
            for (String suffix : gwwhit$ALLOWED_SUFFIXES) {
                if (path.endsWith(suffix)) {
                    return true;
                }
            }
            return false;
        };
    }

    @Redirect(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Ljava/util/Map;",
            at = @At(value = "INVOKE",
                    target = "Ljava/lang/String;substring(II)Ljava/lang/String;"))
    private String changeId(String instance, int beginIndex, int endIndex) {
        for (String suffix : gwwhit$ALLOWED_SUFFIXES) {
            if (instance.endsWith(suffix)) {
                currentSuffix = suffix;
                return instance.substring(beginIndex, instance.length() - suffix.length());
            }
        }
        throw new IllegalStateException("Unsupported suffix passed path check!");
    }

    @Redirect(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Ljava/util/Map;",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/util/JsonHelper;deserialize(Lcom/google/gson/Gson;Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;"))
    private <T> T swapSerializer(Gson gson, Reader reader, Class<T> class_) {
        if (class_ == JsonElement.class && ArrayUtils.contains(gwwhit$YAML_SUFFIXES, currentSuffix)) {
            Object data = new Yaml().load(reader);
            // We know that T is JsonElement due to the class check
            // noinspection unchecked
            return (T) gson.toJsonTree(data);
        }

        return JsonHelper.deserialize(gson, reader, class_);
    }
}
