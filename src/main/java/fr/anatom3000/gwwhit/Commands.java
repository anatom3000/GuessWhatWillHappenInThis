package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.block.entity.InfectedMassBlockEntity;
import fr.anatom3000.gwwhit.block.entity.RandomisingBlockEntity;
import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.config.ConfigManager;
import me.shedaniel.autoconfig.ConfigHolder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;

public class Commands {

    private Commands() {}


    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(CommandManager.literal(GWWHIT.MOD_ID)
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("config")
                        .then(CommandManager.literal("sync")
                            .executes(context -> {
                                for (ServerPlayerEntity player : context.getSource().getMinecraftServer().getPlayerManager().getPlayerList()) {
                                    ServerPlayNetworking.send(player, GWWHIT.CONFIG_SYNC_ID, ConfigManager.toPacketByteBuf());
                                }
                                return 1;
                            })
                                .then(CommandManager.argument("targets", EntityArgumentType.players())
                                    .executes(context -> {
                                        for (ServerPlayerEntity player : EntityArgumentType.getPlayers(context, "targets")) {
                                            ServerPlayNetworking.send(player, GWWHIT.CONFIG_SYNC_ID, ConfigManager.toPacketByteBuf());
                                        }
                                        return 1;
                                    })
                                )
                        )
                        .then(CommandManager.literal("load")
                            .executes(context -> {
                                ConfigHolder<ModConfig> configHolder = ConfigManager.getHolder();
                                configHolder.load();
                                return 1;
                            })
                        )
                        .then(CommandManager.literal("reload")
                            .executes(context -> {
                                ConfigManager.load();
    
                                for (ServerPlayerEntity player : context.getSource().getMinecraftServer().getPlayerManager().getPlayerList()) {
                                    ServerPlayNetworking.send(player, GWWHIT.CONFIG_SYNC_ID, ConfigManager.toPacketByteBuf());
                                }
                                return 1;
                            })
                        )
                )
                .then(CommandManager.literal("debug")
                        .then(CommandManager.literal("remove_destructive_blocks")
                                .executes(context -> {
                                    int ticks = context.getSource().getMinecraftServer().getTicks();
                                    InfectedMassBlockEntity.removeTick = ticks;
                                    RandomisingBlockEntity.removeTick = ticks;
                                    return 1;
                                })
                        )
                )
        ));
    }
}