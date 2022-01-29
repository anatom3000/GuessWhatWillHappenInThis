package fr.anatom3000.gwwhit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.anatom3000.gwwhit.command.Commands;
import fr.anatom3000.gwwhit.config.AnnotationExclusionStrategy;
import fr.anatom3000.gwwhit.dimension.RandomChunkGenerator;
import fr.anatom3000.gwwhit.registry.*;
import fr.anatom3000.gwwhit.util.NarratorExt;
import fr.anatom3000.gwwhit.util.TableRandomizer;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static fr.anatom3000.gwwhit.Const.ASSETS_ROOT;
import static fr.anatom3000.gwwhit.Const.MOD_ID;

/*  IMPORTANT NOTICE:
    When adding to this mod make sure you follow proper naming standards:
        Classes                                     ThisIsAClass
        Static final fields and enum constants      THIS_IS_STATIC_FINAL
        Everything else                             thisIsEverythingElse
*/

public class GWWHIT implements ModInitializer {
    //Locations / Ids
    public static final ModContainer CONTAINER = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
    public static final Identifier CONFIG_SYNC_ID = getId("config_sync");

    //Instances of configurable utils
    public static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).create();
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final Random RANDOM = new Random();
    public static final TableRandomizer TABLE_RANDOMIZER = new TableRandomizer(RANDOM);
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID);

    //Caches
    public static final Map<String, Map<String, String>> TRANSLATIONS = new HashMap<>();

    public static Identifier getId(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        Python.load();
        cacheTranslations();
        Registry.register(Registry.CHUNK_GENERATOR, getId("random"), RandomChunkGenerator.CODEC);
        ItemRegistry.register();
        BlockRegistry.register();
        BlockEntityRegistry.register();
        Commands.register();
        EnchantmentRegistry.register();
        NewMaterials.onInitialize();
        EventListeners.register();
        NarratorExt.getInstance().gwwhit$load();
        LOGGER.info("[GWWHIT] You shouldn't have done this. (Loading done)");
    }

    private void cacheTranslations() {
        try {
            for (Path path : Files.list(ASSETS_ROOT.resolve("lang")).collect(Collectors.toList())) {
                String name = path.getFileName().toString();
                name = name.substring(0, name.lastIndexOf('.'));
                try (InputStream is = Files.newInputStream(path); InputStreamReader ir = new InputStreamReader(is)) {
                    TRANSLATIONS.put(name, GSON.fromJson(ir, TypeUtils.parameterize(HashMap.class, String.class, String.class)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
