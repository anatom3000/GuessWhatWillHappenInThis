package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.Const;
import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.AudioConfig;
import fr.anatom3000.gwwhit.util.CheatCodes;
import io.gitlab.jfronny.libjf.data.manipulation.api.UserResourceEvents;
import net.devtech.arrp.api.RRPCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import java.nio.file.Files;
import java.util.Objects;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

/*
-javaagent:"C:\Users\Michele\.gradle\caches\modules-2\files-2.1\net.fabricmc\sponge-mixin\0.11.2+mixin.0.8.5\f4ae569d559b5e3244b67321945261d83ff7ad8e\sponge-mixin-0.11.2+mixin.0.8.5.jar"
 */
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
        // --- AUTHOR: ENDERZOMBI102 ---
        PlayerBlockBreakEvents.AFTER.register(
                (world, player, pos, state, blockEntity) -> {
                    if (ConfigManager.getActiveConfig().gameplay.stoneBlocksAreInfected) {
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
        // --- END AUTHOR ---
        RRPCallback.AFTER_VANILLA.register( a -> a.add(GWWHIT.RESOURCE_PACK) );

        UserResourceEvents.OPEN.register( (type, id, previous, pack) -> {
            if ( id.getPath().endsWith(".ogg") ) {
                AudioConfig.SoundReplacement r = ConfigManager.getActiveConfig().audio.soundReplacement;
                if ( r != AudioConfig.SoundReplacement.None )
                    return Files.newInputStream( Const.ASSETS_ROOT.resolve("sounds/" + r.name().toLowerCase() + ".ogg") );
            }
            return previous.get();
        });
    }

    public static void registerClient() {
        ConfigManager.getHolder().registerSaveListener( ( holder, cfg ) -> {
            if ( MinecraftClient.getInstance().isIntegratedServerRunning() ) {
                ConfigManager.setActiveConfig( cfg );
                ConfigManager.syncConfig(
                        Objects.requireNonNull( MinecraftClient.getInstance().getServer() ),
                        MinecraftClient.getInstance().getServer().getPlayerManager().getPlayer(
                                Objects.requireNonNull( MinecraftClient.getInstance().player ).getUuid()
                        )
                );
            }
            return ActionResult.SUCCESS;
        } );
    }
}
