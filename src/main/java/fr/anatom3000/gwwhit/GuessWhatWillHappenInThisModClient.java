package fr.anatom3000.gwwhit;

import com.google.gson.JsonSyntaxException;
import fr.anatom3000.gwwhit.config.ModConfig;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import fr.anatom3000.gwwhit.registry.NewMaterials;

public class GuessWhatWillHappenInThisModClient implements ClientModInitializer {

    public static final Identifier WHISTLE_SOUND = new Identifier("gwwhit:whatsapp_whistle");
    public static final SoundEvent WHISTLE_SOUND_EVENT = new SoundEvent(WHISTLE_SOUND);

    @Override
    public void onInitializeClient() {
        NewMaterials.onInitializeClient();

        //ClientPlayNetworking.registerGlobalReceiver(GuessWhatWillHappenInThisMod.ID("reload_chunks"), (client, networkHandler, data, sender) -> client.execute(client.worldRenderer::reload));
        Registry.register(Registry.SOUND_EVENT, WHISTLE_SOUND, WHISTLE_SOUND_EVENT);

        ClientPlayNetworking.registerGlobalReceiver(GuessWhatWillHappenInThisMod.CONFIG_SYNC_ID, (client, networkHandler, data, sender) -> {
            ModConfig config = null;
            try {
                config = GuessWhatWillHappenInThisMod.GSON.fromJson(data.readString(), ModConfig.class);
            } catch (JsonSyntaxException syntaxError) {
                GuessWhatWillHappenInThisMod.LOGGER.warn("Failed to load synced config, falling back to local config!");
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
