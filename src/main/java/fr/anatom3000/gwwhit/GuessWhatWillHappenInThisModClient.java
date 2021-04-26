package fr.anatom3000.gwwhit;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class GuessWhatWillHappenInThisModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(GuessWhatWillHappenInThisMod.ID("reload_chunks"), (client, networkHandler, data, sender) -> client.execute(client.worldRenderer::reload));
    }

}
