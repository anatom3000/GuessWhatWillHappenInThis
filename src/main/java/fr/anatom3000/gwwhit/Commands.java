package fr.anatom3000.gwwhit;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class Commands {

    private Commands() {}

    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(CommandManager.literal(GuessWhatWillHappenInThisMod.MOD_ID)
                .then(CommandManager.literal("pill")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            Config.getInstance().takePill();
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            if (player != null) {
                                String msg = Config.getInstance().isPillTaken() ? "§6[§eGWWHITM§6] §3You wake up!" : "§6[§eGWWHITM§6] §3Everything stays the same!";
                                ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                player.sendMessage(new LiteralText(msg), false);
                            }
                            return 1;
                        })
                )
                .then(CommandManager.literal("killgod")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            Config.getInstance().killGod();
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            String msg = Config.getInstance().isGodDead() ? "§6[§eGWWHITM§6] §3God is dead!" : "§6[§eGWWHITM§6] §3God is alive!";
                            if (player != null) {
                                player.sendMessage(new LiteralText(msg), false);
                            }
                            return 1;
                        })
                )
                .then(CommandManager.literal("killrngesus")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            Config.getInstance().killRNGesus();
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            String msg = Config.getInstance().isRNGesusDead() ? "§6[§eGWWHITM§6] §3RNGesus is dead!" : "§6[§eGWWHITM§6] §3RNGesus is alive!";
                            if (player != null) {
                                player.sendMessage(new LiteralText(msg), false);
                            }
                            return 1;
                        })
                )
                .then(CommandManager.literal("electrifymouse")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            Config.getInstance().electrifyMouse();
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            String msg = Config.getInstance().isMouseElectric() ? "§6[§eGWWHITM§6] §3Let's get funky!" : "§6[§eGWWHITM§6] §3Rip dedma!";
                            if (player != null) {
                                player.sendMessage(new LiteralText(msg), false);
                            }
                            return 1;
                        })
                )
                .then(CommandManager.literal("spin")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            Config.getInstance().changeSpin();
                            ServerPlayerEntity player = context.getSource().getPlayer();
                            String msg = Config.getInstance().spinIsUnlocked() ? "§6[§eGWWHITM§6] §3Achieved perfection!" : "§6[§eGWWHITM§6] §3Bye, Johnny!";
                            if (player != null) {
                                ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                player.sendMessage(new LiteralText(msg), false);
                            }
                            return 1;
                        })
                )
        ));

    }

}
