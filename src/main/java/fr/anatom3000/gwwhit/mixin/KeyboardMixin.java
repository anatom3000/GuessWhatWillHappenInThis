package fr.anatom3000.gwwhit.mixin;

import com.google.common.collect.ImmutableMap;
import com.mojang.authlib.GameProfile;
import fr.anatom3000.gwwhit.util.CheatCodes;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(Keyboard.class)
public class KeyboardMixin {

	private final Random random = new Random();
	@Shadow
	@Final
	private MinecraftClient client;
	private String CURRENT_STRING = "";

	@Inject(at = @At("HEAD"), method = "onChar")
	public void onChar (long window, int i, int j, CallbackInfo ci) {
		if (window == this.client.getWindow().getHandle() && this.client.player != null) {
			if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 67) || !InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), 292)) {
				this.CURRENT_STRING += Character.toUpperCase((char) i);
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
				if ( this.CURRENT_STRING.endsWith( cheatCode.code ) ){
					if ( cheatCode.needsPlayer() && player == null) continue;
					cheatCode.onExecute(player, abilities);
				}
			}

		}
	}
}