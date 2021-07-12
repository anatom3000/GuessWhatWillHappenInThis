package fr.anatom3000.gwwhit.util;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
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
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Random;

import static fr.anatom3000.gwwhit.util.Utilities.insertMany;

public class CheatCodes {

	public static int MAX_CHEAT_LEN = 0;

	public static final ArrayList<CheatCode> CHEAT_CODES = new ArrayList<>() {{
		add(new CheatCode("POWEROVERWHELMING") {  // cheat 1
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				abilities.invulnerable = !abilities.invulnerable;
				player.sendAbilitiesUpdate();
				client.player.sendChatMessage("Nothing can stop you!");
			}
		});
		add(new CheatCode("PIGSONTHEWING") {  // cheat 2
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				abilities.allowFlying = !abilities.allowFlying;
				player.sendAbilitiesUpdate();
				client.player.sendChatMessage("FLYING=VERY YES");
			}
		});
		add(new CheatCode("FLASHAAAAA") {  // cheat 3
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 20));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 20));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200, 20));
				client.player.sendChatMessage("Gordon's ALIVE!");
			}
		});
		add(new CheatCode("MOREDAKKA") {  // cheat 4
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				ItemStack crossbow = new ItemStack(Items.CROSSBOW);
				EnchantmentHelper.set(ImmutableMap.of(Enchantments.MULTISHOT, 12), crossbow);

				insertMany(
						player.getInventory(),
						crossbow,
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_SWORD),
								30,
								true
						),
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_AXE),
								30,
								true
						),
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_PICKAXE),
								30,
								true
						),
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_HOE),
								30,
								true
						),
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.SHEARS),
								30,
								true
						),
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.BOW),
								30,
								true
						),
						new ItemStack( Items.ARROW, 64 )
				);
				player.equipStack(
						EquipmentSlot.HEAD,
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_HELMET),
								30,
								true
						)
				);
				player.equipStack(
						EquipmentSlot.CHEST,
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_CHESTPLATE),
								30,
								true
						)
				);
				player.equipStack(
						EquipmentSlot.LEGS,
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_LEGGINGS),
								30,
								true
						)
				);
				player.equipStack(
						EquipmentSlot.FEET,
						EnchantmentHelper.enchant(
								random,
								new ItemStack(Items.NETHERITE_BOOTS),
								30,
								true
						)
				);
				player.equipStack(
						EquipmentSlot.OFFHAND,
						new ItemStack(Items.SHIELD)
				);
				client.player.sendChatMessage("Got all equipment!");
			}
		});
		add(new CheatCode("IDKFA") {  // cheat 5
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				// TODO: RESTORE
				client.player.sendChatMessage("Got all keys!");
			}
		});
		add(new CheatCode("COWSCOWSCOWS") {  // cheat 6
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				client.player.sendChatMessage("There is no cow level");
			}
		});
		add(new CheatCode("HOWDOYOUTURNTHISON") {  // cheat 7
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				Vec3d playerPos = player.getPos();
				Vec3d vector = new Vec3d(
						playerPos.x + (double) (random.nextFloat() * 3.0F),
						playerPos.y,
						playerPos.z + (double) (random.nextFloat() * 3.0F)
				);
				HorseEntity horse = EntityType.HORSE.create(player.world);
				horse.setPosition(vector.x, vector.y, vector.z);
				horse.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(200.0D);
				horse.getAttributeInstance(EntityAttributes.HORSE_JUMP_STRENGTH).setBaseValue(3.0D);
				horse.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(3.0D);
				horse.setTame(true);
				horse.setTemper(0);
				horse.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_HORSE_ARMOR));
				//horse.equipStack(EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, 400), new ItemStack(Items.SADDLE));
				horse.saddle(null);
				player.world.spawnEntity(horse);
				client.player.sendChatMessage("VROOM!");
			}
		});
		add(new CheatCode("NEEEERD") {  // cheat 8
			@Override
			public void onExecute(ServerPlayerEntity player, PlayerAbilities abilities) {
				CreeperEntity creeper = null;
				for (int var3 = 0; var3 < 5; var3++) {
					CreeperEntity newCreeper = EntityType.CREEPER.create(player.world);
					newCreeper.setPosition(player.getX() + 0.5D, player.getY() + 0.5D, player.getZ() + 0.5D);
					player.world.spawnEntity(newCreeper);
					if (creeper != null)
						creeper.startRiding(newCreeper, true);
					creeper = newCreeper;
				}
				client.player.sendChatMessage("Special creeper has been spawned nearby!");
			}
		});
		add(new CheatCode("LOOKMUMIMFLYING") {
			@Override
			public void onExecute(ServerPlayerEntity player, @Nullable PlayerAbilities abilities) {
				player.setNoGravity(! player.hasNoGravity() );
				client.player.sendChatMessage("U R JESUS??");
			}
		});
		add(new CheatCode("LIKANOTHAWORLD") {
			@Override
			public void onExecute(ServerPlayerEntity player, @Nullable PlayerAbilities abilities) {
				ServerWorld world = player.getServer().getWorld(
						RegistryKey.of(
								Registry.WORLD_KEY,
								new Identifier( "minecraft", "nether")
						)
				);
				double x = world.getSpawnPos().getX(), y = world.getSpawnPos().getY(), z = world.getSpawnPos().getZ();
				player.teleport(
						world,
						x, y, z,
						player.getYaw(),
						player.getPitch()
				);
				client.player.sendChatMessage("U R GOING TO BRAZIL!");
			}
		});
	}};

	public static abstract class CheatCode {

		protected static final Random random = new Random();
		protected static final MinecraftClient client = MinecraftClient.getInstance();

		public String code;

		/**
		 * This constructor sets the maximum cheat length
		 * @param code The code your cheat will be activated by.
		 */
		public CheatCode(String code) {
			this.code = code;
			MAX_CHEAT_LEN = MAX_CHEAT_LEN < code.length() ? MAX_CHEAT_LEN = code.length() : MAX_CHEAT_LEN;
		}

		/**
		 * This function will run on the logical server
		 * @param player the player instance.
		 * @param abilities the player's abilities.
		 */
		public abstract void onExecute( @Nullable ServerPlayerEntity player, @Nullable PlayerAbilities abilities );
	}

	public static final class CheatCodeRunner implements Runnable {
		private final String code;
		private final ServerPlayerEntity player;

		public CheatCodeRunner(String code, ServerPlayerEntity player) {
			this.code = code;
			this.player = player;
		}

		@Override
		public void run() {
			for ( CheatCode cheat : CHEAT_CODES ) {
				if ( cheat.code.equals(code) )
					cheat.onExecute( player, player.getAbilities() );
			}
		}
	}
}