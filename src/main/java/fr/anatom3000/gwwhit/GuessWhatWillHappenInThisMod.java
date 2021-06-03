package fr.anatom3000.gwwhit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.config.AnnotationExclusionStrategy;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.registry.BlockRegistry;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.item.Items;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/*  IMPORTANT NOTICE:
	When adding to this mod make sure you follow proper naming standards:
		Classes 								ThisIsAClass
		Static final fields and enum constants 	THIS_IS_STATIC_FINAL
		Everything else  						thisIsEverythingElse
*/


public class GuessWhatWillHappenInThisMod implements ModInitializer {
	//We use a custom ExclusionStrategy to make sure we don't serialize things that break
	public static final Gson GSON = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy()).create();

	public static final String MOD_ID = "gwwhit";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final Random RANDOM = new Random();

	//TODO: change case
    public static Identifier ID(String path) {
		return new Identifier(MOD_ID, path);
	}

	private static final Identifier LE_BLAZE_LOOT = new Identifier("minecraft", "entities/blaze");
	private static final Identifier LE_BARTER_LOOT = new Identifier("minecraft", "gameplay/piglin_bartering");
	private static final Identifier LE_NEW_BARTER_LOOT = ID("gameplay/new_piglin_barter");

	public static final Identifier CONFIG_SYNC_ID = ID("config_sync");

	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID + ":data");

	FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
			.rolls(UniformLootTableRange.between(0,1))
			.with(ItemEntry.builder(Items.BLAZE_ROD))
			.withCondition(RandomChanceLootCondition.builder(0.38f).build());

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, (definition, configClass) -> new GsonConfigSerializer<>(definition, configClass, GSON));
		
		ItemRegistry.register();
		BlockRegistry.register();
		BlockEntityRegistry.register();
		Commands.register();
		NewMaterials.INSTANCE.onInitialize();
		registerLootTables();
		registerEvents();
		LOGGER.info("[GWWHIT] You shouldn't have done this.");
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

	private void registerEvents() {
		PlayerBlockBreakEvents.AFTER.register(
				(world, player, pos, state, blockEntity) -> {
					if ( ModConfig.getLoadedConfig().blocks.stoneBlocksAreInfected) {
						// AUTHOR: ENDERZOMBI102
						if ( state.getMaterial() == Material.STONE ) {
							SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
							silverfishEntity.refreshPositionAndAngles(
									(double)pos.getX() + 0.5D,
									pos.getY(),
									(double)pos.getZ() + 0.5D,
									0.0F,
									0.0F
							);
							world.spawnEntity(silverfishEntity);
							silverfishEntity.playSpawnEffects();
						}
					}
				}
		);
		RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));
	}

}





