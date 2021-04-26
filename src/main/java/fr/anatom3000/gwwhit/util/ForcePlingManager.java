package fr.anatom3000.gwwhit.util;

import java.util.Collection;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import io.github.haykam821.pling.Pling;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public final class ForcePlingManager {
	private static final Identifier FORCE_PLING_ID = new Identifier("gwwhit", "force_pling");

	private ForcePlingManager() {
		return;
	}

	public static void register() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			dispatcher.register(CommandManager.literal("forcepling")
				.then(CommandManager.argument("targets", EntityArgumentType.players())
				.executes(ForcePlingManager::execute)));
		});
	}

	@Environment(EnvType.CLIENT)
	public static void registerClient() {
		ClientPlayNetworking.registerGlobalReceiver(FORCE_PLING_ID, (client, handler, buf, responseSender) -> {
			Pling.playEffects();
		});
	}

	public static int execute(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
		Collection<ServerPlayerEntity> targets = EntityArgumentType.getPlayers(context, "targets");

		Packet<?> packet = ServerPlayNetworking.createS2CPacket(FORCE_PLING_ID, new PacketByteBuf(Unpooled.buffer()));
		for (ServerPlayerEntity player : targets) {
			player.networkHandler.sendPacket(packet);
		}

		return targets.size();
	}
}
