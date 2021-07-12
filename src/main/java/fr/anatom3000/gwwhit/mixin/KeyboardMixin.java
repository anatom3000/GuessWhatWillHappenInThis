package fr.anatom3000.gwwhit.mixin;

import com.mojang.authlib.GameProfile;
import fr.anatom3000.gwwhit.util.CheatCodes;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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
			GameProfile profile = this.client.player != null ? this.client.player.getGameProfile() : null;

			ServerPlayerEntity player = server != null && profile != null ?
							server.getPlayerManager().getPlayer( profile.getId() ) :
							null;
			PlayerAbilities abilities = player != null ? player.getAbilities() : null;

			for ( CheatCodes.CheatCode cheatCode : CheatCodes.CHEAT_CODES ) {
				if ( this.CURRENT_STRING.endsWith( cheatCode.code ) ) {
					if ( cheatCode.needsPlayer() && player == null ) continue;
					cheatCode.onExecute(player, abilities);
				}
			}

		}
	}
}