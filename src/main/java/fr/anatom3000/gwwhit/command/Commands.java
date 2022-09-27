package fr.anatom3000.gwwhit.command;

import fr.anatom3000.gwwhit.Const;
import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.Python;
import fr.anatom3000.gwwhit.block.entity.InfectedMassBlockEntity;
import fr.anatom3000.gwwhit.block.entity.RandomisingBlockEntity;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.mixin.access.GameRendererAccess;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.command.argument.ItemStackArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvents;

public class Commands {
    private Commands() {
    }

    public static void registerClient() {
        if (ConfigManager.getActiveConfig().misc.debugMode)
            ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("gwwhitclient")
                    .then(ClientCommandManager.literal("set_shader")
                            .then(ClientCommandManager.argument("name", IdentifierArgumentType.identifier())
                                    .executes(context -> {
                                        Identifier id = context.getArgument("name", Identifier.class);

                                        ((GameRendererAccess)MinecraftClient.getInstance().gameRenderer).callLoadShader(id);
                                        return 1;
                                    })
                            )
                    ));
    }

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(CommandManager.literal(Const.MOD_ID)
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("config")
                        .then(CommandManager.literal("reload")
                                .executes(ctx -> {
                                    ConfigManager.getHolder().load();
                                    ConfigManager.setActiveConfig(null);
                                    ConfigManager.syncConfig( ctx.getSource().getServer(), null );
                                    return 1;
                                })
                        )
                )
                .then(CommandManager.literal("debug")
                        .then(CommandManager.literal("remove_destructive_blocks")
                                .executes(context -> {
                                    int ticks = context.getSource().getServer().getTicks();
                                    InfectedMassBlockEntity.removeTick = ticks;
                                    RandomisingBlockEntity.removeTick = ticks;
                                    return 1;
                                })
                        )
                )
                .then(CommandManager.literal("python")
                        .requires(source -> ConfigManager.getActiveConfig().misc.scripting)
                        .then(CommandManager.literal("execute")
                                .then(CommandManager.argument("script", new ScriptArgumentType())
                                        .executes(context -> {
                                            try {
                                                Python.execute(ScriptArgumentType.getScript(context, "script"));
                                                return 1;
                                            } catch (RuntimeException e) {
                                                context.getSource().sendError(new LiteralText(createErrorMessage(e, 0)));
                                                return 0;
                                            }
                                        })
                                )
                        )
                )
                .then(CommandManager.literal("fillinv")
                        .then(CommandManager.argument("item", ItemStackArgumentType.itemStack())
                                .executes(context -> {
                                    ItemStackArgument item = ItemStackArgumentType.getItemStackArgument(context, "item");
                                    ItemStack stack = item.createStack(item.getItem().getMaxCount(), false);
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    if (player == null) return 0;

                                    for (int i = 0; i < player.getInventory().size(); i++) {
                                        player.getInventory().setStack(i, stack.copy());
                                    }

                                    for (int i = 0; i < player.getEnderChestInventory().size(); i++) {
                                        player.getEnderChestInventory().setStack(i, stack.copy());
                                    }

                                    return 1;
                                })
                        )
                )
                .then(CommandManager.literal("hi")
                        .executes(context -> {
                            context.getSource().getPlayer().playSound(SoundEvents.BLOCK_WOOL_PLACE, 1.0f, 1.0f);
                            context.getSource().getPlayer().sendMessage(new LiteralText("hi"), true);
                            return 1;
                        })
                )
        ));
    }

    private static String createErrorMessage(Throwable e, int indentation) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(indentation));
        sb.append(e.getMessage());
        sb.append('\n');
        for (Throwable t : e.getSuppressed()) sb.append(createErrorMessage(t, indentation + 1));
        return sb.toString();
    }
}
