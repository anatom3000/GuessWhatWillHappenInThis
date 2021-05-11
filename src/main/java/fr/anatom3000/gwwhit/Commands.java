package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.config.ModConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;

public class Commands {

    private Commands() {}
    
    
    public static void register() {
        /*
        SuggestionProvider<ServerCommandSource> provider = SuggestionProviders.register(GuessWhatWillHappenInThisMod.ID("config_key"), (commandContext, suggestionsBuilder) -> {
            for (String s : OldConfig.ALL_CONFIG_KEYS)
                suggestionsBuilder.suggest(s);
            //suggestionsBuilder.suggest("*");
            return suggestionsBuilder.buildFuture();
        });
        */
        
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(CommandManager.literal(GuessWhatWillHappenInThisMod.MOD_ID)
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("reloadconfig")
                    .executes(context -> {
                        ConfigHolder<ModConfig> configHolder = ModConfig.getHolder();
                        configHolder.load();
                        
                        for (ServerPlayerEntity player : context.getSource().getMinecraftServer().getPlayerManager().getPlayerList()) {
                            ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.CONFIG_SYNC_ID, configHolder.getConfig().getSyncable());
                        }
                        
                        return 1;
                    })
                )
        ));
        
        /*
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(CommandManager.literal(GuessWhatWillHappenInThisMod.MOD_ID)
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("toggle")
                        .then(CommandManager.argument("config_key", StringArgumentType.word()).suggests(provider)
                                .executes(context -> {
                                    String option = StringArgumentType.getString(context, "config_key");
                                    OldConfig config = OldConfig.getInstance();
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    config.invertValue(option);
                                    if (player != null) {
                                        if (config.needsReRender(option)) ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                        player.sendMessage(new LiteralText(config.getMsg(option)), false);
                                    }
                                    
                                    return 1;
                                })
                        )
                        .then(CommandManager.literal("*")
                                .executes(context -> {
                                    OldConfig config = OldConfig.getInstance();
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    for (String setting : OldConfig.ALL_CONFIG_KEYS) {
                                        config.invertValue(setting);
                                    }
                                    if (player != null) {
                                        ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                        player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3Omega swap!"), false);
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
                                            OldConfig config = OldConfig.getInstance();
                                            boolean oldValue;
                                            ServerPlayerEntity player = context.getSource().getPlayer();
    
                                            oldValue = config.getValue(option);
                                            config.setValue(option, value);
                                            if (player != null) {
                                                if (config.needsReRender(option))
                                                    ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                                player.sendMessage(new LiteralText(config.getMsg(option)), false);
                                            }
                                            return oldValue == value ? 0 : 1;
                                        })
                                )
                        )
                        .then(CommandManager.literal("*")
                                .then(CommandManager.argument("value", BoolArgumentType.bool())
                                    .executes(context -> {
                                        boolean value = BoolArgumentType.getBool(context, "value");
                                        OldConfig config = OldConfig.getInstance();
                                        ServerPlayerEntity player = context.getSource().getPlayer();
                                        for (String setting : OldConfig.ALL_CONFIG_KEYS) {
                                            config.setValue(setting, value);
                                        }
                                        if (player != null) {
                                            ServerPlayNetworking.send(player, GuessWhatWillHappenInThisMod.ID("reload_chunks"), new PacketByteBuf(Unpooled.buffer()));
                                            player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3Lets gooo!"), false);
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
                                    boolean value = OldConfig.getInstance().getValue(option);
                                    OldConfig config = OldConfig.getInstance();
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    if (option.equals("*")) {
                                        int enabledCount = 0;
                                        if (player != null) {
                                            for (String setting : OldConfig.ALL_CONFIG_KEYS) {
                                                player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3" + setting + " is set to " + config.getValue(setting)), false);
                                                ++enabledCount;
                                            }
                                        }
                                        return enabledCount;
                                    }
                                    
                                    if (player != null) {
                                        player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3" + option + " is set to " + value), false);
                                    }
                                    return value ? 1 : 0;
                                })
                                
                        )
                        .then(CommandManager.literal("*")
                                .executes(context -> {
                                    OldConfig config = OldConfig.getInstance();
                                    ServerPlayerEntity player = context.getSource().getPlayer();
                                    int enabledCount = 0;
                                    if (player != null) {
                                        for (String setting : OldConfig.ALL_CONFIG_KEYS) {
                                            player.sendMessage(new LiteralText("§6[§eGWWHITM§6] §3" + setting + " is set to " + config.getValue(setting)), false);
                                            ++enabledCount;
                                        }
                                    }
                                    return enabledCount;
                                })
                        )
                )
        ));
         */
    }
}
