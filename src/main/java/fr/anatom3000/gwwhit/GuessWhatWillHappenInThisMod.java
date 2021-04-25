package fr.anatom3000.gwwhit;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuessWhatWillHappenInThisMod implements ModInitializer {
	public static final Logger logger = LogManager.getLogger("gwwhit");
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
	}
}
