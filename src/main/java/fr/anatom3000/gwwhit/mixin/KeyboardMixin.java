package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.util.CheatCodes;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

@Mixin(Keyboard.class)
public class KeyboardMixin {

	@Shadow
	@Final
	private MinecraftClient client;
	private String CURRENT_STRING = "";

	@Inject(at = @At("HEAD"), method = "onChar")
	public void onChar (long window, int i, int j, CallbackInfo ci) {
		if (window == this.client.getWindow().getHandle() && this.client.player != null) {
			if (
					!InputUtil.isKeyPressed( MinecraftClient.getInstance().getWindow().getHandle(), 67 ) ||
					!InputUtil.isKeyPressed( MinecraftClient.getInstance().getWindow().getHandle(), 292 )
			) {
				this.CURRENT_STRING += Character.toUpperCase( (char) i );
			}
			if (this.CURRENT_STRING.length() > CheatCodes.MAX_CHEAT_LEN) {
				this.CURRENT_STRING = this.CURRENT_STRING.substring(this.CURRENT_STRING.length() - CheatCodes.MAX_CHEAT_LEN);
			}

			MinecraftServer server = this.client.getServer();

			// search the cheat code
			for ( CheatCodes.CheatCode cheatCode : CheatCodes.CHEAT_CODES ) {
				if ( this.CURRENT_STRING.endsWith( cheatCode.code ) ) {
					// code found
					if ( server == null ) {
						// we're connected to a server, send a packet
						PacketByteBuf buf = PacketByteBufs.create();
						NbtCompound nbt = new NbtCompound();
						nbt.putString( "cheat", cheatCode.code );
						buf.writeNbt( nbt );
						ClientPlayNetworking.send( getId("cheat_codes_channel"), buf );
					} else {
						// we're connected to the integrated server, do it directly
						try {
							ServerPlayerEntity player = server.getPlayerManager().getPlayer(
									this.client.player.getGameProfile().getId()
							);
							assert player != null;
							cheatCode.onExecute( player, player.getAbilities() );
						} catch (AssertionError ignored) { }
					}

				}
			}

		}
	}
}