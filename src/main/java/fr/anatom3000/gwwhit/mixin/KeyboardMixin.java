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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
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
			if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT6)) {
				this.client.player.sendChatMessage("There is no cow level");
			} else if (server != null && profile != null) {
				ServerPlayerEntity player = server.getPlayerManager().getPlayer(profile.getId());
				if (player != null) {
					if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT5)) {
						// TODO: RESTORE
						this.client.player.sendChatMessage("Got all keys!");
					} else if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT4)) {
						ItemStack var2 = new ItemStack(Items.CROSSBOW);
						EnchantmentHelper.set(ImmutableMap.of(Enchantments.MULTISHOT, 12), var2);
						player.inventory.insertStack(var2);
						player.inventory.insertStack(EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_SWORD), 30, true));
						player.inventory.insertStack(EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_AXE), 30, true));
						player.inventory.insertStack(EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_PICKAXE), 30, true));
						player.inventory.insertStack(EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_HOE), 30, true));
						player.inventory.insertStack(EnchantmentHelper.enchant(this.random, new ItemStack(Items.SHEARS), 30, true));
						player.inventory.insertStack(EnchantmentHelper.enchant(this.random, new ItemStack(Items.BOW), 30, true));
						player.equipStack(EquipmentSlot.HEAD, EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_HELMET), 30, true));
						player.equipStack(EquipmentSlot.CHEST, EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_CHESTPLATE), 30, true));
						player.equipStack(EquipmentSlot.LEGS, EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_LEGGINGS), 30, true));
						player.equipStack(EquipmentSlot.FEET, EnchantmentHelper.enchant(this.random, new ItemStack(Items.DIAMOND_BOOTS), 30, true));
						player.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
						this.client.player.sendChatMessage("Got all equipment!");
					} else if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT2)) {
						player.abilities.allowFlying = !player.abilities.allowFlying;
						player.sendAbilitiesUpdate();
						this.client.player.sendChatMessage("FLYING=VERY YES");
					} else if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT1)) {
						player.abilities.invulnerable = !player.abilities.invulnerable;
						player.sendAbilitiesUpdate();
						this.client.player.sendChatMessage("Nothing can stop you!");
					} else if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT3)) {
						player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 20));
						player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 20));
						player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200, 20));
						this.client.player.sendChatMessage("Gordon's ALIVE!");
					} else if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT7)) {
						Vec3d playerPos = player.getPos();
						Vec3d vector = new Vec3d(playerPos.x + (double) (this.random.nextFloat() * 3.0F), playerPos.y, playerPos.z + (double) (this.random.nextFloat() * 3.0F));
						HorseEntity horse = EntityType.HORSE.create(player.world);
						horse.updatePosition(vector.x, vector.y, vector.z);
						horse.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(200.0D);
						horse.getAttributeInstance(EntityAttributes.HORSE_JUMP_STRENGTH).setBaseValue(3.0D);
						horse.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(3.0D);
						horse.setTame(true);
						horse.setTemper(0);
						horse.equip(401, new ItemStack(Items.DIAMOND_HORSE_ARMOR));
						horse.equip(400, new ItemStack(Items.SADDLE));
						player.world.spawnEntity(horse);
						this.client.player.sendChatMessage("VROOM!");
					} else if (this.CURRENT_STRING.endsWith(CheatCodes.CHEAT8)) {
						BlockPos var2 = player.getBlockPos();

						for (int var3 = 0; var3 < 5; ++var3) {
							CreeperEntity creeper = EntityType.CREEPER.create(player.world);
							creeper.updatePosition(player.getX() + 0.5D, player.getY() + 0.5D, player.getZ() + 0.5D);
							//var5.wouldPoseNotCollide();
							player.world.spawnEntity(creeper);
							this.client.player.sendChatMessage("Special creeper has been spawned nearby!");
							break;
						}
					}
				}
			}
		}
	}
}