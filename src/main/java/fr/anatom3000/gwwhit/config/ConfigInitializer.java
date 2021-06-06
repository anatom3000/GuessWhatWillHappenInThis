package fr.anatom3000.gwwhit.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.anatom3000.gwwhit.GWWHIT;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class ConfigInitializer {
    private static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).setPrettyPrinting().create();
    
    public static void initialize() {
        AutoConfig.register(ModConfig.class, (definition, configClass) -> new GsonConfigSerializer<>(definition, configClass, GSON));
    }
}
