package fr.anatom3000.gwwhit;

import com.google.gson.Gson;
import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.registry.BlockRegistry;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;

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
	//public static final Gson GSON = new Gson();
	public static final Jankson JANKSON = Jankson.builder().build();

	public static final String MOD_ID = "gwwhit";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final Random rng = new Random();

    public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static final Identifier LE_BLAZE_LOOT = new Identifier("minecraft", "entities/blaze");
	public static final Identifier LE_BARTER_LOOT = new Identifier("minecraft", "gameplay/piglin_bartering");
	public static final Identifier LE_NEW_BARTER_LOOT = ID("gameplay/new_piglin_barter");

	public static final Identifier CONFIG_SYNC_ID = ID("config_sync");

	FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
			.rolls(UniformLootTableRange.between(0,1))
			.with(ItemEntry.builder(Items.BLAZE_ROD))
			.withCondition(RandomChanceLootCondition.builder(0.38f).build());

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);

		ItemRegistry.register();
		BlockRegistry.register();
		BlockEntityRegistry.register();
		Commands.register();
		NewMaterials.INSTANCE.onInitialize();
		registerLootTables();
		LOGGER.info("You shouldn't have done this.");
	}

	private void registerLootTables() {
		LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
			if (ModConfig.getLoadedConfig().drops.dreamLuck) {
				if (LE_BLAZE_LOOT.equals(id)) {
					supplier.withPool(poolBuilder.build());
				} else if (LE_BARTER_LOOT.equals(id)) {
					setter.set(manager.getTable(LE_NEW_BARTER_LOOT));
				}
			}
		});
	}

}





