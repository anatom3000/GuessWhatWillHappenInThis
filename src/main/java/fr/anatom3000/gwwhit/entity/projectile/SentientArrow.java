package fr.anatom3000.gwwhit.entity.projectile;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.common.collect.Lists;
//import com.quartzshard.aasb.common.damage.source.AASBDmgSrc;
//import com.quartzshard.aasb.common.entity.ai.ArrowPathNavigation;
//import com.quartzshard.aasb.common.item.equipment.armor.jewelry.AmuletItem;
//import com.quartzshard.aasb.common.network.AASBNet;
//import com.quartzshard.aasb.common.network.client.CreateLoopingSoundPacket;
//import com.quartzshard.aasb.common.network.client.DrawParticleLinePacket;
//import com.quartzshard.aasb.common.network.client.CreateLoopingSoundPacket.LoopingSound;
//import com.quartzshard.aasb.common.network.client.DrawParticleLinePacket.LineParticlePreset;
//import com.quartzshard.aasb.config.DebugCfg;
//import com.quartzshard.aasb.data.AASBTags.BlockTP;
//import com.quartzshard.aasb.data.AASBTags.EntityTP;
//import com.quartzshard.aasb.init.EffectInit;
//import com.quartzshard.aasb.init.ObjectInit;
//import com.quartzshard.aasb.util.EntityHelper;
//import com.quartzshard.aasb.util.LogHelper;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.entity.ai.ArrowPathNavigation;
import fr.anatom3000.gwwhit.mixin.access.EntityAccessor;
import fr.anatom3000.gwwhit.mixin.access.PersistentProjectileEntityAccessor;
import fr.anatom3000.gwwhit.mixin.access.ProjectileEntityAccessor;
import fr.anatom3000.gwwhit.registry.EntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNode;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

//import net.minecraft.core.BlockPos;
//import net.minecraft.core.particles.ParticleTypes;
//import net.minecraft.network.syncher.EntityDataAccessor;
//import net.minecraft.network.syncher.EntityDataSerializers;
//import net.minecraft.network.syncher.SynchedEntityData;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.util.Mth;
//import net.minecraft.world.damagesource.DamageSource;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.projectile.AbstractArrow;
//import net.minecraft.world.entity.projectile.ProjectileUtil;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.ClipContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.gameevent.GameEvent;
//import net.minecraft.world.level.pathfinder.Node;
//import net.minecraft.world.level.pathfinder.Path;
//import net.minecraft.world.phys.net.minecraft.util.math.Box;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.EntityHitResult;
//import net.minecraft.world.phys.HitResult;
//import net.minecraft.world.phys.net.minecraft.util.math.Vec3d;
//import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * An arrow that will automatically search for, chase, and kill entities <br>
 * Intelligently navigates around obstacles, and can be manually redirected by its owner
 * @author solunareclipse1, quartzshard
 */
public class SentientArrow extends PersistentProjectileEntity {
	
	private ArrowPathNavigation nav = new ArrowPathNavigation(this, world);
	
	/** when tickCount > this, arrow dies */
	private final int maxLife;
	
	private enum ArrowState {
		SEARCHING, // Looking for a target
		DIRECT,    // Has direct line of sight to target
		PATHING,   // Following path to to target
		INERT
	}
	private static final TrackedData<Byte> AI_STATE = DataTracker.registerData(SentientArrow.class, TrackedDataHandlerRegistry.BYTE);
	private static final TrackedData<Integer> TARGET_ID = DataTracker.registerData(SentientArrow.class, TrackedDataHandlerRegistry.INTEGER);
	
	/**
	 * the position we are currently going toward <br>
	 * usually the position of target entity, or next node in path
	 */
	@Nullable
	private net.minecraft.util.math.Vec3d targetPos = null;
	
	/** The current path we are moving along */
	@Nullable
	private Path currentPath = null;
	
	/**
	 * "memory" of previous paths this arrow has taken <br>
	 * used for making sure its not going in circles
	 */
	private Stack<Path> previousPaths = new Stack<>();
	
	private boolean isReturningToOwner = false;
	private int searchTime = 0;
	
	public SentientArrow(EntityType<? extends SentientArrow> entityType, World level) {
		super(entityType, level);
		maxLife = 200;
	}

	public SentientArrow(World level, double x, double y, double z) {
		super(EntityRegistry.SENTIENT_ARROW_ENTITY, x,y,z, level);
		maxLife = 200;
	}

	public SentientArrow(World level, LivingEntity shooter) {
		super(EntityRegistry.SENTIENT_ARROW_ENTITY, shooter, level);
		maxLife = 200;
	}

	@Override
	public void initDataTracker() {
		super.initDataTracker();
		dataTracker.startTracking(AI_STATE, (byte) 0);
		dataTracker.startTracking(TARGET_ID, -1);
	}
	
	@Override
	public void tick() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "Tick");
		if ( age > maxLife || owner() == null ) {
			//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "OldOrBadOwner");
			this.kill();
		}
		else if (age < 5) {
			//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "YoungArrow");
			this.setPosition(getPos().add(this.getVelocity()));
		}
		else {
			if (isLookingForTarget()) {
				//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "LookingForTarget");
				if (searchTime < 10) {
					searchTime++;
					if (!attemptAutoRetarget() && searchTime >= 10) {
						if (age == searchTime) {
							becomeInert();
						}
						else {
							isReturningToOwner = true;
						}
					}
				} else {
					becomeInert();
				}
			}
			// TRAJECTORY MODIFICATION
			if (isHoming()) {
				//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "Homing");
				Entity target = isReturningToOwner ? owner() : getTarget();
				if (isReturningToOwner || this.shouldContinueHomingTowards(target)) {
					boolean lineOfSight = canSee(target);
					if (lineOfSight) {
						//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "LineOfSight");
						// BEELINE
						forgetPaths();
						targetPos = target.getBoundingBox().getCenter();
						if (getState() != ArrowState.DIRECT) {
							//particles(0);
							setState(ArrowState.DIRECT); // target visible
						}
					} else {
						//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "Obstructed");
						// PATHFIND
						setState(ArrowState.PATHING); // target obstructed
						pathTo(target);
					}
					if (!isInert() && targetPos != null) {
						//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "Redirecting");
						if (!world.isClient) {
							shootAt(targetPos, 3f);
						}
					}
				} else {
					//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "InvalidTarget");
					resetTarget();
					setState(ArrowState.SEARCHING); // searching for target
				}
			}
			// MOVEMENT & COLLISION
			moveAndCollide();
		}
		this.velocityDirty = true;
	}
	
	@Override
	protected void onBlockHit(BlockHitResult hitRes) {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "OnHitBlock");
		BlockPos pos = hitRes.getBlockPos();
		BlockState hit = world.getBlockState(hitRes.getBlockPos());
		if (isLookingForTarget()) {
			if (!attemptAutoRetarget()) {
				becomeInert();
			}
		}
		if (isInert()) {
			super.onBlockHit(hitRes);
		}
	}
	
	@Override
	protected void onEntityHit(EntityHitResult hitRes) {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "OnHitEntity");
		Entity hit = hitRes.getEntity();
		if (isReturningToOwner && hit.isPartOf(owner())) {
			isReturningToOwner = false;
			if (!attemptAutoRetarget()) {
				isReturningToOwner = true;
			}
		} else if (!hit.isPartOf(owner())) {
			// not owner
			if (hit instanceof LivingEntity entity) {
				attemptToTransmuteEntity(entity);
			}
		}
	}
	
	/**
	 * AbstractArrow.tick() with some minor changes
	 */
	private void moveAndCollide() {
		projectileTick();
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "MoveAndCollide");
		boolean noClip = !isInert() || this.isNoClip();
		net.minecraft.util.math.Vec3d curPos = this.getPos();
		net.minecraft.util.math.Vec3d motion = getVelocity();
		double horizVel = motion.horizontalLength();
		if (!world.isClient && this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
			this.setPitch((float)(MathHelper.atan2(motion.y, horizVel) * (180F / (float)Math.PI)));
			this.setYaw((float)(MathHelper.atan2(motion.x, motion.z) * (180F / (float)Math.PI)));
			this.prevPitch = this.getPitch();
			this.prevYaw = this.getYaw();
		}

		BlockPos curBlockPos = this.getBlockPos();
		BlockState blockInside = this.world.getBlockState(curBlockPos);
		if (!blockInside.isAir()) {
			/*if (blockInside.is(BlockTP.ARROW_ANNIHILATE)) {
				if (transmuteBlockIntoCovDust(curBlockPos)) {
					level.playSound(null, curBlockPos, PESoundEvents.DESTRUCT.get(), this.getSoundSource(), 1, 2);
					return; // dont need to process collision on something that doesnt exist
				}
			} else*/ if (!noClip) {
				VoxelShape blockShape = blockInside.getCollisionShape(this.world, curBlockPos);
				if (!blockShape.isEmpty()) {

					for(net.minecraft.util.math.Box aabb : blockShape.getBoundingBoxes()) {
						//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "Blocknet.minecraft.util.math.BoxCollisionLoop");
						if (aabb.offset(curBlockPos).contains(curPos)) {
							this.inGround = true;
							break;
						}
					}
				}
			}
		}

		if (this.shake > 0) {
			if (noClip) this.shake = 0;
			else this.shake--;
		}

		if (noClip || this.isTouchingWaterOrRain() || blockInside.isOf(Blocks.POWDER_SNOW)) {
			this.extinguish();
		}
		
		if (this.inGround && !noClip) {
			PersistentProjectileEntityAccessor ths = ((PersistentProjectileEntityAccessor)this);
			BlockState lastState = ths.getInBlockState();
			if (lastState != blockInside && ths.callShouldFall()) {
				ths.callFall();
			} else if (!this.world.isClient) {
				this.age();
			}
			++this.inGroundTime;
		} else {
			this.inGroundTime = 0;
			net.minecraft.util.math.Vec3d nextPos = curPos.add(motion);
			HitResult hitRes = this.world.raycast(new RaycastContext(curPos, nextPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
			if (hitRes.getType() != HitResult.Type.MISS) {
				if ( !noClip && !canNoclipThrough(world.getBlockState(new BlockPos(hitRes.getPos()))) ) {
					nextPos = hitRes.getPos();
				}
			}

			boolean didHit = false;
			while(!this.isRemoved()) {
				//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "EntCollisionLoop");
				EntityHitResult entHitRes = this.getEntityCollision(curPos, nextPos);
				if (entHitRes != null) {
					hitRes = entHitRes;
				}

				if (hitRes != null && hitRes.getType() == HitResult.Type.ENTITY) {
					Entity victim = ((EntityHitResult)hitRes).getEntity();
					Entity owner = this.getOwner();
					if (victim instanceof PlayerEntity plrVictim && owner instanceof PlayerEntity plrOwner && !plrOwner.shouldDamagePlayer(plrVictim)) {
						hitRes = null;
						entHitRes = null;
					}
				}

				if (hitRes != null && hitRes.getType() != HitResult.Type.MISS && !this.isNoClip() /*&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitRes)*/) {
					this.onCollision(hitRes);
					didHit = true;
					this.velocityDirty = true;
				}

				// game hangs without the pierce level check
				// NOTE TO SELF: do not ever give this a pierce value
				if (entHitRes == null || this.getPierceLevel() <= 0) {
					break;
				}

				hitRes = null;
			}
			if (!didHit && isHoming()) {
				Entity target = isReturningToOwner ? owner() : getTarget();
				if (target != null && target.getBoundingBox().contains(getPos())) {
					onCollision(new EntityHitResult(target, getPos()));
				}
			}
			
			double velX = motion.x;
			double velY = motion.y;
			double velZ = motion.z;
			if (world instanceof ServerWorld lvl) {
				//ParticleOptions particle = WispParticleData.wisp(0.5f, Color.PHILOSOPHERS.R/255f, Color.PHILOSOPHERS.G/255f, Color.PHILOSOPHERS.B/255f, 1);
				//MiscHelper.drawVectorWithParticles(position(), position().add(getDeltaMovement()), particle, 0.1, lvl);
				//for(int i = 0; i < 24; ++i) {
				//	this.level.addParticle(particle, this.getX() + velX * (double)i / 4.0D, this.getY() + velY * (double)i / 4.0D, this.getZ() + velZ * (double)i / 4.0D, 0,0,0);//-velX, -velY + 0.2D, -velZ);
				//}
				// TODO: fix clientside jank because doing this every tick is bad juju
				for (ServerPlayerEntity plr : lvl.getPlayers()) {
					BlockPos pos = plr.getBlockPos();
					if (pos.isWithinDistance(this.getPos(), 96d)) {
						// like hell am i reimplementing this
						//AASBNet.toClient(new DrawParticleLinePacket(position().add(getDeltaMovement()), position(), LineParticlePreset.SENTIENT_TRACER), plr);
					}
				}
			}

			double nextX = getX() + velX;
			double nextY = getY() + velY;
			double nextZ = getZ() + velZ;
			//double horizVel = vel.horizontalDistance();
			setYaw((float)(MathHelper.atan2(velX, velZ) * (180d / (float)Math.PI)));
			setPitch((float)(MathHelper.atan2(velY, horizVel) * (180d / (float)Math.PI)));
			setPitch(updateRotation(this.prevPitch, this.getPitch()));
			setYaw(updateRotation(this.prevYaw, this.getYaw()));
			float resistanceFactor = 0.99f;
			//float f1 = 0.05F;
			if (this.isTouchingWater()) {
				for(int j = 0; j < 4; ++j) {
					//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "InWaterLoop");
					//float f2 = 0.25F;
					this.world.addParticle(ParticleTypes.BUBBLE, nextX - velX * 0.25, nextY - velY * 0.25, nextZ - velZ * 0.25, velX, velY, velZ);
				}

				resistanceFactor = this.getDragInWater();
			}
			if (noClip) resistanceFactor = 1;

			this.setVelocity(motion.multiply(resistanceFactor));
			if (!this.hasNoGravity() && !noClip) {
				net.minecraft.util.math.Vec3d vec34 = this.getVelocity();
				this.setVelocity(vec34.x, vec34.y - 0.05, vec34.z);
			}

			this.setPos(nextX, nextY, nextZ);
			this.checkBlockCollision();
		}
	}
	
	public static boolean canNoclipThrough(BlockState state) {
		// i dont know how to do tags on fabric :3
		return state.isOf(Blocks.AIR)
				|| state.isOf(Blocks.ICE)
				|| state.isOf(Blocks.FROSTED_ICE)
				|| state.isOf(Blocks.SCAFFOLDING)
				|| state.isOf(Blocks.LAVA)
				|| state.isOf(Blocks.IRON_BARS)
				|| state.isIn(BlockTags.SIGNS)
				|| state.isIn(BlockTags.LEAVES)
				|| state.isIn(BlockTags.BANNERS)
				|| state.isIn(BlockTags.BUTTONS)
				|| state.isIn(BlockTags.CROPS)
				|| state.isIn(BlockTags.REPLACEABLE_PLANTS)
				|| state.isIn(BlockTags.FLOWERS)
				|| state.isIn(BlockTags.CLIMBABLE);
	}
	
	/**
	 * identical to Projectile.tick()
	 */
	private void projectileTick() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "ProjectileTick");
		ProjectileEntityAccessor ths = ((ProjectileEntityAccessor)this);
		if (!ths.getShot()) {
			this.emitGameEvent(GameEvent.PROJECTILE_SHOOT, this.getOwner(), this.getBlockPos());
			ths.setShot(true);
		}

		if (!ths.getLeftOwner()) {
			ths.setLeftOwner(ths.callShouldLeaveOwner());
		}

		entityTick();
	}

	/**
	 * identical to Entity.tick()
	 */
	private void entityTick() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "EntityTick");
		EntityAccessor ths = ((EntityAccessor)this);
		this.world.getProfiler().push("entityBaseTick");
		ths.setBlockStateAtPos(null);
		if (this.hasVehicle() && this.getVehicle().isRemoved()) {
			this.stopRiding();
		}

		if (this.ridingCooldown > 0) {
			--this.ridingCooldown;
		}

		this.prevHorizontalSpeed = this.horizontalSpeed;
		this.prevPitch = this.getPitch();
		this.prevYaw = this.getYaw();
		this.tickNetherPortal();
		if (this.shouldSpawnSprintingParticles()) {
			this.spawnSprintingParticles();
		}

		this.wasInPowderSnow = this.inPowderSnow;
		this.inPowderSnow = false;
		this.updateWaterState();
		ths.callUpdateSubmergedInWaterState();
		this.updateSwimming();
		int remainingFireTicks = this.getFireTicks();
		if (this.world.isClient) {
			this.extinguish();
		} else if (remainingFireTicks > 0) {
			if (this.isFireImmune()) {
				this.setFireTicks(remainingFireTicks - 4);
				if (remainingFireTicks < 0) {
					this.extinguish();
				}
			} else {
				if (remainingFireTicks % 20 == 0 && !this.isInLava()) {
					this.damage(DamageSource.ON_FIRE, 1.0F);
				}

				this.setFireTicks(remainingFireTicks - 1);
			}

			if (this.getFrozenTicks() > 0) {
				this.setFrozenTicks(0);
				this.world.syncWorldEvent((PlayerEntity)null, 1009, this.getBlockPos(), 1);
			}
		}

		if (this.isInLava()) {
			this.setOnFireFromLava();
			this.fallDistance *= 0.5F;
		}

		this.attemptTickInVoid();
		if (!this.world.isClient) {
			this.setOnFire(remainingFireTicks > 0);
		}

		this.firstUpdate = false;
		this.world.getProfiler().pop();
	}
	
	
	
	
	
	
	
	
	///////////////
	// FUNCTIONS //
	///////////////
	public void becomeInert() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "BecomingInert");
		this.setState(ArrowState.INERT);
		resetTarget();
	}
	
	@Override
	public void kill() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "EndOfLife");
		//playSound(EffectInit.ARCHANGELS_EXPIRE.get(), 1, 1);
		if (getOwner() != null) {
			//level.playSound(null, getOwner().blockPosition(), EffectInit.ARCHANGELS_EXPIRE.get(), SoundSource.PLAYERS, 1, 0.1f);
		}
		discard();
	}
	
	private boolean canSee(Entity ent) {
		return (!ent.isInvisible() || ent.isGlowing()) && canSee(ent.getBoundingBox().getCenter());
	}
	private boolean canSee(net.minecraft.util.math.Vec3d pos) {
		return isUnobstructed(this.getBoundingBox().getCenter(), pos);
		//BlockHitResult hitRes = this.level.clip(new ClipContext(this.getBoundingBox().getCenter(), pos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
		//if (hitRes != null && hitRes.getType() == HitResult.Type.BLOCK && !level.getBlockState(hitRes.getBlockPos()).is(BlockTP.ARROW_NOCLIP)) {
		//	return false;
		//}
		//return true;
	}
	private boolean isUnobstructed(net.minecraft.util.math.Vec3d start, net.minecraft.util.math.Vec3d end) {
		BlockHitResult hitRes = this.world.raycast(new RaycastContext(start, end, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
		if (hitRes != null && hitRes.getType() == HitResult.Type.BLOCK && !canNoclipThrough(world.getBlockState(hitRes.getBlockPos())) ) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	private void shootAt(Entity ent) {
		shootAt(ent, 1);
	}
	private void shootAt(Entity ent, float vel) {
		shootAt(ent.getBoundingBox().getCenter(), vel);
	}
	@SuppressWarnings("unused")
	private void shootAt(net.minecraft.util.math.Vec3d pos) {
		shootAt(pos, 1);
	}
	private void shootAt(net.minecraft.util.math.Vec3d pos, float vel) {
		net.minecraft.util.math.Vec3d between = pos.subtract(getPos());
		if (between.length() < vel) {
			vel = (float) between.length();
		}
		net.minecraft.util.math.Vec3d heading = between.normalize();
		net.minecraft.util.math.Vec3d motion = heading.multiply(vel);
		setVelocity(heading.x, heading.y, heading.z, (float) motion.length(), 0);
	}
	@Nullable
	private Path findPathTo(@NotNull Entity ent) {
		return findPathTo(ent.getBoundingBox().getCenter());
	}
	@Nullable
	private Path findPathTo(net.minecraft.util.math.Vec3d pos) {
		return nav.createPath(pos, 0);
	}
	
	private Path trimNodes(Path path) {
		List<PathNode> nodes = Lists.newArrayList();
		nodes.add(path.getNode(0));
		for (int i = 1; i < path.getLength() - 1; i++) {
			//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "NodeTrimLoop");
			if (!isUnobstructed(nodes.get(nodes.size() - 1).getPos(), path.getNode(i+1).getPos())) {
				nodes.add(path.getNode(i));
			}
		}
		nodes.add(path.getEnd());
		return new Path(nodes, path.getTarget(), path.reachesTarget());
	}
	
	private boolean isPathInsane(Path path) {
		boolean isInsane = path == null || path.equalsPath(currentPath) || path.getNode(0) == path.getEnd();
		if (!isInsane) {
			for (Path oldPath : previousPaths) {
				//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "PathInsanityLoop");
				if (path.equalsPath(oldPath)) {
					isInsane = true;
					break;
				}
			}
		}
		return isInsane;
	}
	private void changeTargetPos(net.minecraft.util.math.Vec3d newPos, boolean particles) {
		targetPos = newPos;
	}
	
	/**
	 * @param target
	 * @return if pathfinding was unsuccessfull
	 */
	private void pathTo(Entity ent) {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "PathTo");
		Entity target = ent;
		Path lastMemorized = null;
		while (!hasPath()) {
			//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "FindPathLoop");
			// FIND PATH
			if (currentPath != null && !currentPath.equalsPath(lastMemorized)) {
				previousPaths.push(currentPath);
				lastMemorized = currentPath;
			}
			Path newPath = findPathTo(target);
			boolean insane;
			if (newPath == null) {
				insane = true;
			} else {
				newPath = trimNodes(newPath);
				insane = isPathInsane(newPath);
			}
			if (insane) {
				if (isReturningToOwner) {
					isReturningToOwner = false;
					becomeInert();
					return;
				}
				if (!attemptAutoRetarget()) {
					isReturningToOwner = true;
					target = owner();
					continue;
				}
			}
			currentPath = newPath;
			break;
		}
		if (!isInert()) {
			// FOLLOW PATH
			PathNode node = currentPath.getLastNode();
			if (node == null) {
				node = currentPath.getNode(0);
			}
			PathNode nextNode = currentPath.getCurrentNode();
			net.minecraft.util.math.Vec3d nextTargetPos = net.minecraft.util.math.Vec3d.ofCenter(nextNode.getBlockPos());
			if (nextTargetPos != null) {
				if (targetPos == null || !nextTargetPos.isInRange(targetPos, 0.5)) {
					targetPos = nextTargetPos;
					//particles(0);
				} else {
					targetPos = nextTargetPos;
				}
			}
			if (targetPos != null && this.getPos().isInRange(targetPos, 0.5)) {
				currentPath.next();
			}
		}
	}
	private void particles(int type) {
		// stubbed because too much work
	}
	
	/**
	 * 
	 * @param blockPos
	 * @return if was successfull
	 */
	private boolean transmuteBlockIntoCovDust(BlockPos blockPos) {
		// this doesnt even make sense for this mod
		return false;
	}
	
	private void attemptToTransmuteEntity(LivingEntity entity) {
		// die!!!!!!
		entity.kill();
	}
	
	protected void drawDebugPath(Path path) {
		// also not applicable here
	}
	
	
	//////////////////////
	// TARGET SELECTION //
	//////////////////////
	private LivingEntity findTargetNear(net.minecraft.util.math.Vec3d pos) {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "FindTargetNear");
		if (!world.isClient()) {
			List<LivingEntity> validTargets = world.getEntitiesByClass(LivingEntity.class, net.minecraft.util.math.Box.of(pos, 128, 128, 128), SentientArrow.this::isValidHomingTargetForAutomatic);
			if (!validTargets.isEmpty()) {
				validTargets.sort(Comparator.comparing(SentientArrow.this::squaredDistanceTo, Double::compare));
				LivingEntity chosenTarget = null;
				for (LivingEntity candidate : validTargets) {
					// gets closest entity with line of sight
					if (world.raycast(new RaycastContext(pos, candidate.getBoundingBox().getCenter(), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this)).getType() == HitResult.Type.MISS) {
						chosenTarget = candidate;
						break;
					}
				}
				if (chosenTarget == null) {
					// if there were none with line of sight, just go with closest
					chosenTarget = validTargets.get(0);
				}
				world.playSound(null, this.getBlockPos(), GWWHIT.SNIPER_NS_EVENT, this.getSoundCategory(), 1f, 1);
				world.playSound(null, chosenTarget.getBlockPos(), GWWHIT.SNIPER_NS_EVENT, this.getSoundCategory(), 1f, 0.5f);
				return chosenTarget;
			}
		}
		return null;
	}
	private boolean attemptAutoRetarget() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "AutoTargetAttempt");
		LivingEntity newTarget = findTargetNear(this.getBoundingBox().getCenter());
		if (newTarget != null && !newTarget.isPartOf(getTarget())) {
			setTarget(newTarget.getId());
			setState(ArrowState.DIRECT); // target visible
			searchTime = 0;
			particles(1);
			return true;
		}
		return false;
	}
	public boolean attemptManualRetarget() {
		//if (DebugCfg.LOGS.get()) LogHelper.debug("SentientArrow", "ManualTargetAttempt");
		if (isInert()) {
			setState(ArrowState.DIRECT);
		}
		Entity owner = getOwner();
		if (owner == null) return false;
		if (this.inGround) {
			// teleport to owner if we are stuck
			long teleCost = (long) getPos().distanceTo(owner.getPos()) * (maxLife - age);
			if (true){
				inGround = false;
				world.playSound(null, this.getBlockPos(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, this.getSoundCategory(), 1, 2);
				world.playSound(null, owner.getBlockPos(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, this.getSoundCategory(), 1, 2);
				this.setPosition(owner.getPos());
			}
		}
		// Entity oldTarget = getTarget();
		net.minecraft.util.math.Vec3d ray = owner.getRotationVector().multiply(128);
		EntityHitResult hitRes = ProjectileUtil.getEntityCollision(world, owner, owner.getEyePos(), owner.getEyePos().add(ray), owner.getBoundingBox().stretch(ray).expand(1.0D), SentientArrow.this::isValidHomingTarget);
		if (hitRes != null && !inGround) {
			BlockHitResult sightCheck = world.raycast(new RaycastContext(owner.getEyePos(), hitRes.getEntity().getBoundingBox().getCenter(), RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, owner));
			if (sightCheck != null && sightCheck.getType() != HitResult.Type.MISS) return false; // check for blocks in the way
			if (trySwappingTargetTo(hitRes.getEntity())) {
				particles(1);
				return true;
			}
		}
		// not pointing at anything, so recall
		resetTarget();
		isReturningToOwner = true;
		return false;
	}
	private boolean trySwappingTargetTo(Entity newTarget) {
		if (newTarget != null && !newTarget.isPartOf(getTarget())) {
			setTarget(newTarget.getId());
			setState(ArrowState.DIRECT);
			searchTime = 0;
			return true;
		}
		return false;
	}
	protected boolean isValidHomingTarget(LivingEntity entity) {
		PlayerEntity owner = owner();
		return entity != null
				&& owner != null
				&& canTheoreticallyHitEntity(entity)
				&& (!entity.isInvisible() || entity.isGlowing());
	}
	protected boolean isValidHomingTarget(Entity entity) {
		if (entity instanceof LivingEntity ent) {
			return isValidHomingTarget(ent);
		}
		return false;
	}
	protected boolean isValidHomingTargetForAutomatic(LivingEntity entity) {
		return isValidHomingTarget(entity);
	}
	
	protected boolean shouldContinueHomingTowards(Entity entity) {
		if (entity instanceof LivingEntity ent) {
			return canHit(entity)
					&& (!ent.isInvisible() || ent.isGlowing());
		}
		return false;
	}

	@Override
	protected boolean canHit(Entity ent) {
		// we will never hit our owner
		if (ent.isPartOf(owner())) {
			return isReturningToOwner;
		}
		return super.canHit(ent);
	}

	/**
	 * variant of canHitEntity() used in homing target validation
	 * @param ent
	 * @return
	 */
	protected boolean canTheoreticallyHitEntity(Entity ent) {
		boolean canHit = !ent.isPartOf(owner());
		return canHit && super.canHit(ent);
	}
	
	
	
	
	
	
	
	
	
	
	////////////////////////
	// DATA / STATE STUFF //
	////////////////////////
	public ArrowState getState() {
		switch (dataTracker.get(AI_STATE)) {
		case 0:
			return ArrowState.SEARCHING;
		case 1:
			return ArrowState.DIRECT;
		case 2:
			return ArrowState.PATHING;
		default:
			return ArrowState.INERT;
		}
	}
	private void setState(ArrowState newState) {
		switch (newState) {
		case SEARCHING:
			dataTracker.set(AI_STATE, (byte)0);
			break;
		case DIRECT:
			dataTracker.set(AI_STATE, (byte)1);
			break;
		case PATHING:
			dataTracker.set(AI_STATE, (byte)2);
			break;
		case INERT:
			dataTracker.set(AI_STATE, (byte)3);
			break;
		}
	}
	public boolean isLookingForTarget() {
		return getState() == ArrowState.SEARCHING;
	}
	public boolean isHoming() {
		return isReturningToOwner || hasTarget();
	}
	public boolean hasTarget() {
		return (getState() == ArrowState.DIRECT || getState() == ArrowState.PATHING) && getTargetId() != -1;
	}
	public boolean isInert() {
		return getState() == ArrowState.INERT;
	}
	
	public PlayerEntity owner() {
		if (super.getOwner() instanceof PlayerEntity player) {
			return player;
		}
		return null;
	}
	
	@Nullable
	public Entity getTarget() {
		return world.getEntityById(getTargetId());
	}
	public int getTargetId() {
		return dataTracker.get(TARGET_ID);
	}
	public void setTarget(int targetId) {
		dataTracker.set(TARGET_ID, targetId);
	}
	private void resetTarget() {
		searchTime = 0;
		setTarget(-1);
		targetPos = null;
		forgetPaths();
	}
	private void forgetPaths() {
		currentPath = null;
		previousPaths.clear();
	}
	private boolean hasPath() {
		return currentPath != null && !currentPath.isFinished();
	}

	//////////////
	// SETTINGS //
	//////////////
	@Override
	public boolean isImmuneToExplosion() {return true;}
	@Override
	public boolean hasNoGravity() {return !isInert() || super.hasNoGravity();}
	@Override
	protected ItemStack asItemStack() {return ItemStack.EMPTY;}
	@Override
	public boolean shouldSave() {return false;}
}
