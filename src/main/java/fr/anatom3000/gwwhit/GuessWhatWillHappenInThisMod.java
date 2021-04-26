package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.util.CachingTransformer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
	public static final Identifier LE_BLAZE_LOOT = new Identifier("minecraft","entities/blaze");

	FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
			.rolls(UniformLootTableRange.between(0,1))
			.with(ItemEntry.builder(Items.BLAZE_ROD))
			.withCondition(RandomChanceLootCondition.builder(0.38f).build());

	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");

		Logger logger = LogManager.getLogger(GuessWhatWillHappenInThisMod.class);
		final List<String> hugeList = new ArrayList<String>(10000);
        new Thread() {
           public void run() {
               logger.info("Child thread spawned");
               for(String s:hugeList) {
                   ////
				   logger.info(s);
               }
           }
        }.start();
		LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
			if (LE_BLAZE_LOOT.equals(id)) {
				supplier.withPool(poolBuilder.build());
			}
		});
	}
}





