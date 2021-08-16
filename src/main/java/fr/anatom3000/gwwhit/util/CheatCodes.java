package fr.anatom3000.gwwhit.util;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Random;

import static fr.anatom3000.gwwhit.GWWHITClient.ROCK_SOUND_EVENT;
import static fr.anatom3000.gwwhit.util.McUtilities.insertMany;

@SuppressWarnings("SpellCheckingInspection")
public class CheatCodes {

	public static int MAX_CHEAT_LEN = 0;

	public static final ArrayList<CheatCode> CHEAT_CODES = new ArrayList<>() {{
		add(new CheatCode("POWEROVERWHELMING") {  // cheat 1
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				abilities.invulnerable = !abilities.invulnerable;
				player.sendAbilitiesUpdate();
				player.sendMessage( Text.of("Nothing can stop you!"), false );
			}
		});
		add(new CheatCode("PIGSONTHEWING") {  // cheat 2
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				abilities.allowFlying = !abilities.allowFlying;
				player.sendAbilitiesUpdate();
				player.sendMessage( Text.of("FLYING=VERY YES"), false );
			}
		});
		add(new CheatCode("FLASHAAAAA") {  // cheat 3
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 20));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 20));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200, 20));
				player.sendMessage( Text.of("Gordon's ALIVE!"), false );
			}
		});
		add(new CheatCode("MOREDAKKA") {  // cheat 4
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
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
				player.sendMessage( Text.of("Got all equipment!"), false );
			}
		});
		add(new CheatCode("IDKFA") {  // cheat 5
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				// TODO: RESTORE
				player.sendMessage( Text.of("Got all keys!"), false );
			}
		});
		add(new CheatCode("COWSCOWSCOWS") {  // cheat 6
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				player.sendMessage( Text.of("There is no cow level"), false );
			}
		});
		add(new CheatCode("HOWDOYOUTURNTHISON") {  // cheat 7
			@Override
			@SuppressWarnings("ConstantConditions")
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
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
				player.sendMessage( Text.of("VROOM!"), false );
			}
		});
		add(new CheatCode("NEEEERD") {  // cheat 8
			@Override
			@SuppressWarnings("ConstantConditions")
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				CreeperEntity creeper = null;
				for (int var3 = 0; var3 < 5; var3++) {
					CreeperEntity newCreeper = EntityType.CREEPER.create(player.world);
					newCreeper.setPosition(player.getX() + 0.5D, player.getY() + 0.5D, player.getZ() + 0.5D);
					player.world.spawnEntity(newCreeper);
					if (creeper != null)
						creeper.startRiding(newCreeper, true);
					creeper = newCreeper;
				}
				player.sendMessage( Text.of("Special creeper has been spawned nearby!"), false );
			}
		});
		add(new CheatCode("LOOKMUMIMFLYING") {
			@Override
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				player.setNoGravity(! player.hasNoGravity() );
				player.sendMessage( Text.of("U R JESUS??"), false );
			}
		});
		add(new CheatCode("LIKANOTHAWORLD") {
			@Override
			@SuppressWarnings("ConstantConditions")
			public void onExecute(ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
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
				player.sendMessage( Text.of("U R GOING TO BRAZIL!"), false );
			}
		});
		add(new CheatCode("WEWILLUJOE") {
			{
				runOnClient = true;
			}
			@Override
			public void onExecute(@Nullable ServerPlayerEntity player, @NotNull PlayerAbilities abilities) {
				MinecraftClient.getInstance().getSoundManager().play(
						PositionedSoundInstance.master(
								ROCK_SOUND_EVENT,
								1f,
								1f
						)
				);
			}
		});
	}};

	public static abstract class CheatCode {

		protected static final Random random = new Random();
		public final String code;
		/**
		 * Set this to true if you want this cheat to run on the client instead of the server
		 * By doing thing, if the user is connected to a server the cheat will not get the player entity,
		 * only the client-avaliable abilities object.
		 */
		public boolean runOnClient = false;

		/**
		 * This constructor sets the maximum cheat length
		 * @param code The code your cheat will be activated by.
		 */
		public CheatCode(String code) {
			this.code = code;
			MAX_CHEAT_LEN = Math.max( MAX_CHEAT_LEN, code.length() );
		}

		/**
		 * This function will run on the logical server
		 * @param player the player instance.
		 * @param abilities the player's abilities.
		 */
		public abstract void onExecute( @Nullable ServerPlayerEntity player, @NotNull PlayerAbilities abilities );
	}

	@SuppressWarnings("ClassCanBeRecord")
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