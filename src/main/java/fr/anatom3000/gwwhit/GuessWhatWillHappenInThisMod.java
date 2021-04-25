package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.util.CachingTransformer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.function.UnaryOperator;

public class GuessWhatWillHappenInThisMod implements ModInitializer {

	public static final String MOD_ID = "gwwhit";

	public static final Logger logger = LogManager.getLogger(MOD_ID);
	public static final Random rng = new Random();
	public static final CachingTransformer<Item> itemRandomizer = new CachingTransformer<>(s -> Registry.ITEM.getRandom(rng));
	public static final UnaryOperator<ItemStack> itemStackRandomizer = s -> new ItemStack(itemRandomizer.apply(s.getItem()), s.getCount());

    public static Identifier ID(String path) {
    	return new Identifier(MOD_ID, path);
    }

    @Override
	public void onInitialize() {
		Commands.registerCommands();
		System.out.println("You shouldn't have done this.");
	}
}
