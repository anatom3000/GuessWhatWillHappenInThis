package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.util.ForcePlingManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class GuessWhatWillHappenInThisModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ForcePlingManager.registerClient();
	}
}
