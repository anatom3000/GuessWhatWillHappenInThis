package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.MiscConfig;
import fr.anatom3000.gwwhit.event.PlayerDeathEvent;
import fr.anatom3000.gwwhit.util.CheatCodes;
import net.devtech.arrp.api.RRPCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

public class EventListeners {
    private static final Identifier LE_BLAZE_LOOT = new Identifier("minecraft", "entities/blaze");
    private static final Identifier LE_BARTER_LOOT = new Identifier("minecraft", "gameplay/piglin_bartering");
    private static final Identifier LE_NEW_BARTER_LOOT = GWWHIT.getId("gameplay/new_piglin_barter");

    private static final FabricLootPoolBuilder POOL_BUILDER = FabricLootPoolBuilder.builder()
            .rolls(UniformLootNumberProvider.create(0, 1))
            .with(ItemEntry.builder(Items.BLAZE_ROD))
            .withCondition(RandomChanceLootCondition.builder(0.38f).build());

    public static void register() {
        LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
            if (ConfigManager.getActiveConfig().gameplay.dreamLuck) {
                if (LE_BLAZE_LOOT.equals(id)) {
                    supplier.withPool(POOL_BUILDER.build());
                } else if (LE_BARTER_LOOT.equals(id)) {
                    setter.set(manager.getTable(LE_NEW_BARTER_LOOT));
                }
            }
        });

        PlayerBlockBreakEvents.AFTER.register(
                (world, player, pos, state, blockEntity) -> {
                    if (ConfigManager.getActiveConfig().gameplay.stoneBlocksAreInfected) {
                        // AUTHOR: ENDERZOMBI102
                        if (state.getMaterial() == Material.STONE) {
                            SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
                            //noinspection ConstantConditions
                            silverfishEntity.refreshPositionAndAngles(
                                    (double) pos.getX() + 0.5D,
                                    pos.getY(),
                                    (double) pos.getZ() + 0.5D,
                                    0.0F,
                                    0.0F
                            );
                            world.spawnEntity(silverfishEntity);
                            silverfishEntity.playSpawnEffects();
                        }
                    }
                }
        );

        RRPCallback.AFTER_VANILLA.register( a -> a.add(GWWHIT.RESOURCE_PACK) );
        // AUTHOR: ENDERZOMBI102
        //noinspection ConstantConditions
        ServerPlayNetworking.registerGlobalReceiver(
                getId("cheat_codes_channel"),
                (server, player, handler, buf, responseSender) -> server.execute(
                        new CheatCodes.CheatCodeRunner(
                                buf.readNbt().getString("cheat"),
                                player
                        )
                )
        );
    }

    public static void registerClient() {

    }
}
