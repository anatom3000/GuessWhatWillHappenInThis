package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.registry.BlockRegistry;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import fr.anatom3000.gwwhit.registry.PaintingRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Items;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class GuessWhatWillHappenInThisMod implements ModInitializer {

	public static final String MOD_ID = "gwwhit";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final Random rng = new Random();

    public static Identifier ID(String path) {
    	return new Identifier(MOD_ID, path);
    }

	public static final Identifier LE_BLAZE_LOOT = new Identifier("minecraft","entities/blaze");

	FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
			.rolls(UniformLootTableRange.between(0,1))
			.with(ItemEntry.builder(Items.BLAZE_ROD))
			.withCondition(RandomChanceLootCondition.builder(0.38f).build());

	@Override
	public void onInitialize() {
		ItemRegistry.register();
		BlockRegistry.register();
		BlockEntityRegistry.register();
		PaintingRegistry.register();
		Commands.register();
		registerLootTables();
		LOGGER.info("You shouldn't have done this.");
	}

	private void registerLootTables() {
		LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
			if (LE_BLAZE_LOOT.equals(id)) {
				supplier.withPool(poolBuilder.build());
			}
		});
	}

}





