package fr.anatom3000.gwwhit;

import com.google.gson.JsonSyntaxException;
import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GWWHITClient implements ClientModInitializer {

    public static final Identifier WHISTLE_SOUND = new Identifier("gwwhit:whatsapp_whistle");
    public static final SoundEvent WHISTLE_SOUND_EVENT = new SoundEvent(WHISTLE_SOUND);
    public static final Identifier MOJAAAANG_SOUND = new Identifier("gwwhit:mojaaaang");
    public static final SoundEvent MOJAAAANG_SOUND_EVENT = new SoundEvent(MOJAAAANG_SOUND);

    @Override
    public void onInitializeClient() {
        NewMaterials.INSTANCE.onInitializeClient();
        Registry.register(Registry.SOUND_EVENT, WHISTLE_SOUND, WHISTLE_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, MOJAAAANG_SOUND, MOJAAAANG_SOUND_EVENT);

        ClientPlayNetworking.registerGlobalReceiver(GWWHIT.CONFIG_SYNC_ID, (client, networkHandler, data, sender) -> {
            ModConfig config = null;
            try {
                config = GWWHIT.GSON.fromJson(data.readString(), ModConfig.class);
            } catch (JsonSyntaxException syntaxError) {
                GWWHIT.LOGGER.warn("Failed to load synced config, falling back to local config!");
            }
    
            ModConfig finalConfig = config;
            client.execute(() -> {
                ModConfig.loadConfig(finalConfig);
                finalConfig.setShader();
                client.worldRenderer.reload();
            });
        });
    }
}
