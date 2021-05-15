package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.config.ModConfig;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class GuessWhatWillHappenInThisModClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        //ClientPlayNetworking.registerGlobalReceiver(GuessWhatWillHappenInThisMod.ID("reload_chunks"), (client, networkHandler, data, sender) -> client.execute(client.worldRenderer::reload));
    
        ClientPlayNetworking.registerGlobalReceiver(GuessWhatWillHappenInThisMod.CONFIG_SYNC_ID, (client, networkHandler, data, sender) -> {
            ModConfig config = null;
            try {
                config = GuessWhatWillHappenInThisMod.JANKSON.fromJson(data.readString(), ModConfig.class);
            } catch (SyntaxError syntaxError) {
                GuessWhatWillHappenInThisMod.LOGGER.warn("Failed to load synced config, falling back to local config!");
            }
    
            ModConfig finalConfig = config;
            client.execute(() -> {
                ModConfig.setInstance(finalConfig);
                client.worldRenderer.reload();
            });
            
        });
    }
}
