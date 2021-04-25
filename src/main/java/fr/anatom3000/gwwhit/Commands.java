package fr.anatom3000.gwwhit;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
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
                                player.sendMessage(new LiteralText(msg), false);
                                player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3Press F3+A to apply changes."), false);
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
        ));

    }

}
