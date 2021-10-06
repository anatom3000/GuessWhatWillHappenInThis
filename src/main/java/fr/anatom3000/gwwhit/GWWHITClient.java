package fr.anatom3000.gwwhit;

import com.google.gson.JsonSyntaxException;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.MainConfig;
import fr.anatom3000.gwwhit.gui.FurnaceBlockScreen;
import fr.anatom3000.gwwhit.gui.FurnaceGuiDescription;
import fr.anatom3000.gwwhit.registry.EventListeners;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

public class GWWHITClient implements ClientModInitializer {
    public static final Identifier WHISTLE_SOUND = new Identifier("gwwhit:whatsapp_whistle");
    public static final SoundEvent WHISTLE_SOUND_EVENT = new SoundEvent(WHISTLE_SOUND);
    public static final Identifier MOJAAAANG_SOUND = new Identifier("gwwhit:mojaaaang");
    public static final SoundEvent MOJAAAANG_SOUND_EVENT = new SoundEvent(MOJAAAANG_SOUND);
    public static final Identifier ROCK_SOUND = getId("rock");
    public static final SoundEvent ROCK_SOUND_EVENT = new SoundEvent(ROCK_SOUND);


    @Override
    public void onInitializeClient() {
        NewMaterials.onInitializeClient();
        EventListeners.registerClient();
        Registry.register(Registry.SOUND_EVENT, WHISTLE_SOUND, WHISTLE_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, MOJAAAANG_SOUND, MOJAAAANG_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, ROCK_SOUND, ROCK_SOUND_EVENT);

        //noinspection RedundantTypeArguments
        ScreenRegistry.<FurnaceGuiDescription, FurnaceBlockScreen>register(
                GWWHIT.FURNACE_SCREEN_HANDLER_TYPE,
                (gui, inventory, title) -> new FurnaceBlockScreen(gui, inventory.player, title)
        );

        ClientPlayNetworking.registerGlobalReceiver(GWWHIT.CONFIG_SYNC_ID, (client, networkHandler, data, sender) -> {
            MainConfig config = null;
            try {
                if (GWWHIT.MOD_VERSION.equals(data.readString()))
                    config = GWWHIT.GSON.fromJson(data.readString(), MainConfig.class);
            } catch (JsonSyntaxException e) {
                GWWHIT.LOGGER.error("Can't parse config!", e);
            }
            if (config == null) GWWHIT.LOGGER.warn("Failed to load synced config, falling back to local config!");

            MainConfig finalConfig = config;
            client.execute(() -> {
                ConfigManager.loadConfig(finalConfig);
                ConfigManager.setShader();
                client.worldRenderer.reload();
            });
        });
    }
}
