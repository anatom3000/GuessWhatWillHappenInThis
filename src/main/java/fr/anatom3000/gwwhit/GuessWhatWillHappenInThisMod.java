package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.util.CachingTransformer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.function.UnaryOperator;

public class GuessWhatWillHappenInThisMod implements ModInitializer {
	public static final Logger logger = LogManager.getLogger("gwwhit");
	public static final Random rng = new Random();
	public static final CachingTransformer<Item> itemRandomizer = new CachingTransformer<>(s -> Registry.ITEM.getRandom(rng));
	public static final UnaryOperator<ItemStack> itemStackRandomizer = s -> new ItemStack(itemRandomizer.apply(s.getItem()), s.getCount());
	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
	}
}
