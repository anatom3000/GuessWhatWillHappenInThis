package fr.anatom3000.gwwhit;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.suggestion.SuggestionProviders;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

public class Commands {

    private Commands() {}
    
    public static void register() {
        SuggestionProvider<ServerCommandSource> provider = SuggestionProviders.register(GuessWhatWillHappenInThisMod.ID("config_key"), (commandContext, suggestionsBuilder) -> {
            for (String s : Config.ALL_CONFIG_KEYS)
                suggestionsBuilder.suggest(s);
            return suggestionsBuilder.buildFuture();
        });
        
        
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(CommandManager.literal(GuessWhatWillHappenInThisMod.MOD_ID)
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("toggle")
                        .then(CommandManager.argument("config_key", StringArgumentType.word()).suggests(provider)
                                .executes(context -> {
                                    String option = StringArgumentType.getString(context, "config_key");
                                    Config config = Config.getInstance();
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    if (option.equals("deepfry")) {
                                        config.deepfry();
                                        if (player != null) {
                                            if (config.needsReRender(option)) ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                            player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3Deepfried minecraft!"), false);
                                        }
                                    } else {
                                        config.invertValue(option);
                                        if (player != null) {
                                            if (config.needsReRender(option)) ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                            player.sendMessage(new LiteralText(config.getMsg(option)), false);
                                        }
                                    }
                                    
                                    return 1;
                                })
                        )
                )
                .then(CommandManager.literal("set")
                        .then(CommandManager.argument("config_key", StringArgumentType.word()).suggests(provider)
                                .then(CommandManager.argument("value", BoolArgumentType.bool())
                                        .executes(context -> {
                                            String option = StringArgumentType.getString(context, "config_key");
                                            boolean value = BoolArgumentType.getBool(context, "value");
                                            Config config = Config.getInstance();
                                            config.setValue(option, value);
                                            ServerPlayerEntity player = context.getSource().getPlayer();
                                            if (player != null) {
                                                if (config.needsReRender(option)) ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                                player.sendMessage(new LiteralText(config.getMsg(option)), false);
                                            }
                                            return 1;
                                        })
                                )
                        )
                )
                .then(CommandManager.literal("get")
                        .then(CommandManager.argument("config_key", StringArgumentType.word()).suggests(provider)
                                .executes(context -> {
                                    String option = StringArgumentType.getString(context, "config_key");
                                    boolean value = Config.getInstance().getValue(option);
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    if (player != null) {
                                        player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3" + option + " is set to " + value), false);
                                    }
                                    return value ? 1 : 0;
                                })
                                
                        )
                )
                
        ));
    }
}
