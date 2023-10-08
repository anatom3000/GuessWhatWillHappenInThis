package fr.anatom3000.gwwhit.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import fr.anatom3000.gwwhit.entity.projectile.SentientArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ProjectileHelper {
	
	public static class ShootContext {
		@NotNull
		final World level;
		
		@Nullable
		final LivingEntity shooter;
		
		@Nullable
		final Vec3d pos, rot;
		
		public ShootContext(World level, LivingEntity shooter) {
			this.level = level;
			this.shooter = shooter;
			this.pos = null;
			this.rot = new Vec3d(shooter.getPitch(), shooter.getYaw(), 0);
		}
		public ShootContext(World level, LivingEntity shooter, Vec3d rot) {
			this.level = level;
			this.shooter = shooter;
			this.pos = null;
			this.rot = rot;
		}
		public ShootContext(World level, Vec3d pos, Vec3d rot) {
			this.level = level;
			this.shooter = null;
			this.pos = pos;
			this.rot = rot;
		}
	}
	
	public record ArrowOptions(float damage, float velocity, float spread, byte pierce, boolean crit, PersistentProjectileEntity.PickupPermission pickup) {}
	
	public enum ArrowType {
		NORMAL,
		SENTIENT;
		
		PersistentProjectileEntity make(ShootContext ctx, ArrowOptions opts) {
			PersistentProjectileEntity arrow;
			switch (this) {
			case SENTIENT:
				arrow = ctx.shooter == null ?
						new SentientArrow(ctx.level, ctx.pos.x, ctx.pos.y, ctx.pos.z) :
						new SentientArrow(ctx.level, ctx.shooter);
				arrow.setGlowing(true);
				arrow.setDamage(opts.damage);
				break;
				
			default:
				arrow = ctx.shooter == null ?
						new ArrowEntity(ctx.level, ctx.pos.x, ctx.pos.y, ctx.pos.z) :
						new ArrowEntity(ctx.level, ctx.shooter);
				arrow.setDamage(opts.damage);
				break;
			}
			if (ctx.shooter != null) {
				arrow.setVelocity(ctx.shooter, (float)ctx.rot.x, (float)ctx.rot.y, 0, opts.velocity, opts.spread);
			} else {
				float mx = -MathHelper.sin((float) (ctx.rot.y * (Math.PI / 180d))) * MathHelper.cos((float) (ctx.rot.x * (Math.PI / 180d)));
				float my = -MathHelper.sin((float) ((ctx.rot.x + ctx.rot.z) * (Math.PI / 180d)));
				float mz = MathHelper.cos((float) (ctx.rot.y * (Math.PI / 180d))) * MathHelper.cos((float) (ctx.rot.x * (Math.PI / 180d)));
				Random rand = ctx.level.random;
				Vec3d m = new Vec3d(mx, my, mz).normalize().add(rand.nextGaussian() * 0.0075d * opts.spread, rand.nextGaussian() * 0.0075d * opts.spread, rand.nextGaussian() * 0.0075d * opts.spread).multiply(opts.velocity);
				arrow.setVelocity(m);
			}
			arrow.setPierceLevel(opts.pierce);
			arrow.setCritical(opts.crit);
			arrow.pickupType = opts.pickup;
			return arrow;
		}
	}
	
	/**
	 * helper for shooting arrows
	 * @param amount number of arrows to shoot
	 * @param type what kind of arows to shoot
	 * @param ctx the context of shooting
	 * @param opts universal arrow settings
	 * 
	 * @return array of all arrows shot
	 */
	public static List<PersistentProjectileEntity> shootArrow(int amount, ArrowType type, ShootContext ctx, ArrowOptions opts) {
		List<PersistentProjectileEntity> arrows = new ArrayList<>(amount);
		for (int i = 0; i < amount; i++) {
			PersistentProjectileEntity a = type.make(ctx, opts);
			ctx.level.spawnEntity(a);
			ctx.level.playSound(null, a.getX(), a.getY(), a.getZ(),
					SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS,
					1f, 1f / (ctx.level.getRandom().nextFloat() * 0.4f + 1.2f) + (opts.velocity/3f) * 0.5f);
			arrows.add(a);
		}
		return arrows;
	}
}
