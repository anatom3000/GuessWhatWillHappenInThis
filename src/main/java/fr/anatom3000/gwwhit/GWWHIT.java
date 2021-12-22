package fr.anatom3000.gwwhit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.anatom3000.gwwhit.command.Commands;
import fr.anatom3000.gwwhit.config.AnnotationExclusionStrategy;
import fr.anatom3000.gwwhit.dimension.RandomChunkGenerator;
import fr.anatom3000.gwwhit.gui.FurnaceGuiDescription;
import fr.anatom3000.gwwhit.registry.*;
import fr.anatom3000.gwwhit.util.TableRandomizer;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/*  IMPORTANT NOTICE:
    When adding to this mod make sure you follow proper naming standards:
        Classes                                 ThisIsAClass
        Static final fields and enum constants     THIS_IS_STATIC_FINAL
        Everything else                          thisIsEverythingElse
*/


public class GWWHIT implements ModInitializer {
    //Pure constants
    public static final String MOD_ID = "gwwhit";

    //Instances of configurable utils
    public static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).create();
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final Random RANDOM = new Random();
    public static final TableRandomizer TABLE_RANDOMIZER = new TableRandomizer(RANDOM);
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID);

    // screens
    public static ScreenHandlerType<FurnaceGuiDescription> FURNACE_SCREEN_HANDLER_TYPE;

    //Caches
    public static final Map<String, Map<String, String>> TRANSLATIONS = new HashMap<>();

    public static Identifier getId(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        Python.load();
        cacheTranslations();
        FURNACE_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
                getId("slow_furnace"),
                ( syncId, inv ) -> new FurnaceGuiDescription( syncId, inv, ScreenHandlerContext.EMPTY )
        );
        Registry.register(Registry.CHUNK_GENERATOR, new Identifier("gwwhit", "random"), RandomChunkGenerator.CODEC);
        ItemRegistry.register();
        BlockRegistry.register();
        BlockEntityRegistry.register();
        Commands.register();
        EnchantmentRegistry.register();
        NewMaterials.onInitialize();
        EventListeners.register();
        LOGGER.info("[GWWHIT] You shouldn't have done this. (Loading done)");
    }

    @SuppressWarnings("unchecked") //Stupid IntelliJ
    private <T> T deserialize(Reader r, T current) {
        return GSON.fromJson(r, (Class<T>) current.getClass());
    }

    private void cacheTranslations() {
        try {
            for (Path path : Files.list(ASSETS_ROOT.resolve("lang")).collect(Collectors.toList())) {
                String name = path.getFileName().toString();
                name = name.substring(0, name.lastIndexOf('.'));
                try (InputStream is = Files.newInputStream(path); InputStreamReader ir = new InputStreamReader(is)) {
                    TRANSLATIONS.put(name, deserialize(ir, new HashMap<>()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
