package fr.anatom3000.gwwhit.entity.ai;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNode;
import net.minecraft.entity.ai.pathing.PathNodeMaker;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkCache;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;

public class ArrowPathNavigation {
	protected final PersistentProjectileEntity arrow;
	protected final World level;
	@Nullable
	protected Path path;
	protected double speedModifier;
	protected int tick;
	protected int lastStuckCheck;
	protected Vec3d lastStuckCheckPos = Vec3d.ZERO;
	protected Vec3i timeoutCachedNode = Vec3i.ZERO;
	protected long timeoutTimer;
	protected long lastTimeoutCheck;
	protected double timeoutLimit;
	protected float maxDistanceToWaypoint = 0.5F;
	/**
	 * Whether the path can be changed by {@link net.minecraft.pathfinding.PathNavigate#onUpdateNavigation()
	 * onUpdateNavigation()}
	 */
	protected boolean hasDelayedRecomputation;
	protected long timeLastRecompute;
	protected ArrowSeekNodeEvaluator nodeEvaluator;
	@Nullable
	private BlockPos targetPos;
	/** Distance in which a path point counts as target-reaching */
	private int reachRange;
	private float maxVisitedNodesMultiplier = 6.0F;
	private final ArrowSeekPathFinder pathFinder;
	private boolean isStuck;
	private static float FOLLOW_RANGE = 64;

	public ArrowPathNavigation(PersistentProjectileEntity arrow, World level) {
		this.arrow = arrow;
		this.level = level;
		int i = MathHelper.floor(FOLLOW_RANGE * 64.0D);
		pathFinder = createPathFinder(i);
	}

	public void resetMaxVisitedNodesMultiplier() {
		maxVisitedNodesMultiplier = 16.0F;
	}

	public void setMaxVisitedNodesMultiplier(float mult) {
		maxVisitedNodesMultiplier = mult;
	}

	@Nullable
	public BlockPos getTargetPos() {
		return targetPos;
	}

	protected ArrowSeekPathFinder createPathFinder(int maxNodes) {
		nodeEvaluator = new ArrowSeekNodeEvaluator();
		nodeEvaluator.setCanEnterOpenDoors(true);
		return new ArrowSeekPathFinder(nodeEvaluator, maxNodes);
	}

	/**
	 * Sets the speed
	 */
	public void setSpeedModifier(double speed) {
		speedModifier = speed;
	}

	public void recomputePath() {
		if (level.getTime() - timeLastRecompute > 20L) {
			if (targetPos != null) {
				path = null;
				path = createPath(targetPos, reachRange);
				timeLastRecompute = level.getTime();
				hasDelayedRecomputation = false;
			}
		} else {
			hasDelayedRecomputation = true;
		}

	}

	/**
	 * Returns path to given BlockPos
	 */
	@Nullable
	public final Path createPath(double x, double y, double z, int pAccuracy) {
		return createPath(new BlockPos(x, y, z), pAccuracy);
	}
	@Nullable
	public final Path createPath(Vec3d pos, int pAccuracy) {
		return createPath(new BlockPos(pos), pAccuracy);
	}

	/**
	 * Returns a path to one of the elements of the stream or null
	 */
	@Nullable
	public Path createPath(Stream<BlockPos> pTargets, int pAccuracy) {
		return createPath(pTargets.collect(Collectors.toSet()), 8, false, pAccuracy);
	}

	@Nullable
	public Path createPath(Set<BlockPos> pPositions, int pDistance) {
		return createPath(pPositions, 8, false, pDistance);
	}

	/**
	 * Returns path to given BlockPos
	 */
	@Nullable
	public Path createPath(BlockPos pPos, int pAccuracy) {
		return createPath(ImmutableSet.of(pPos), 8, false, pAccuracy);
	}

	@Nullable
	public Path createPath(BlockPos pPos, int pRegionOffset, int pAccuracy) {
		return createPath(ImmutableSet.of(pPos), 8, false, pRegionOffset, pAccuracy);
	}

	/**
	 * Returns a path to the given entity or null
	 */
	@Nullable
	public Path createPath(Entity pEntity, int pAccuracy) {
		return createPath(ImmutableSet.of(pEntity.getBlockPos()), 16, true, pAccuracy);
	}

	/**
	 * Returns a path to one of the given targets or null
	 */
	@Nullable
	protected Path createPath(Set<BlockPos> pTargets, int pRegionOffset, boolean pOffsetUpward, int pAccuracy) {
		return createPath(pTargets, pRegionOffset, pOffsetUpward, pAccuracy, FOLLOW_RANGE);
	}

	@Nullable
	protected Path createPath(Set<BlockPos> pTargets, int pRegionOffset, boolean pOffsetUpward, int pAccuracy, float pFollowRange) {
		if (pTargets.isEmpty()) {
			return null;
		} else if (arrow.getY() < level.getBottomY()) {
			return null;
		} else if (!canUpdatePath()) {
			return null;
		} else if (path != null && !path.isFinished() && pTargets.contains(targetPos)) {
			return path;
		} else {
			level.getProfiler().push("pathfind");
			BlockPos blockpos = pOffsetUpward ? arrow.getBlockPos().up() : arrow.getBlockPos();
			int i = (int)(pFollowRange + pRegionOffset);
			ChunkCache pathnavigationregion = new ChunkCache(level, blockpos.add(-i, -i, -i), blockpos.add(i, i, i));
			Path path = pathFinder.findPath(pathnavigationregion, arrow, pTargets, pFollowRange, pAccuracy, maxVisitedNodesMultiplier);
			level.getProfiler().pop();
			if (path != null && path.getTarget() != null) {
				targetPos = path.getTarget();
				reachRange = pAccuracy;
				resetStuckTimeout();
			}

			return path;
		}
	}

	/**
	 * Try to find and set a path to XYZ. Returns true if successful. Args : x, y, z, speed
	 */
	public boolean moveTo(double x, double y, double z, double speed) {
		return moveTo(createPath(x,y,z, 1), speed);
	}

	/**
	 * Try to find and set a path to EntityLiving. Returns true if successful. Args : entity, speed
	 */
	public boolean moveTo(Entity entity, double speed) {
		Path path = createPath(entity, 1);
		return path != null && moveTo(path, speed);
	}

	/**
	 * Sets a new path. If it's diferent from the old path. Checks to adjust path for sun avoiding, and stores start
	 * coords. Args : path, speed
	 */
	public boolean moveTo(@Nullable Path newPath, double speed) {
		if (newPath == null) {
			path = null;
			return false;
		}
		if (!newPath.equalsPath(path)) {
			path = newPath;
		}

		if (isDone()) {
			return false;
		}
		trimPath();
		if (path.getLength() <= 0) {
			return false;
		}
		speedModifier = speed;
		Vec3d tmpPos = getTempArrowPos();
		lastStuckCheck = tick;
		lastStuckCheckPos = tmpPos;
		return true;
	}

	/**
	 * gets the actively used PathEntity
	 */
	@Nullable
	public Path getPath() {
		return path;
	}

	public void tick() {
		++tick;
		if (hasDelayedRecomputation) {
			recomputePath();
		}

		if (!isDone()) {
			if (canUpdatePath()) {
				followThePath();
			} else if (path != null && !path.isFinished()) {
				Vec3d tmpPos = getTempArrowPos();
				Vec3d nextPos = path.getNodePosition(arrow);
				if (tmpPos.y > nextPos.y && !arrow.isOnGround() && MathHelper.floor(tmpPos.x) == MathHelper.floor(nextPos.x) && MathHelper.floor(tmpPos.z) == MathHelper.floor(nextPos.z)) {
					path.next();
				}
			}
		}
	}

	protected double getGroundY(Vec3d testPos) {
		BlockPos pos = new BlockPos(testPos);
		return level.getBlockState(pos.down()).isAir() ? testPos.y : LandPathNodeMaker.getFeetY(level, pos);
	}

	protected void followThePath() {
		Vec3d tmpPos = getTempArrowPos();
		maxDistanceToWaypoint = arrow.getWidth() > 0.75F ? arrow.getWidth() / 2.0F : 0.75F - arrow.getWidth() / 2.0F;
		Vec3i nextNodePos = path.getCurrentNodePos();
		double xDist = Math.abs(arrow.getX() - (nextNodePos.getX() + (arrow.getWidth() + 1) / 2D)); //Forge: Fix MC-94054
		double yDist = Math.abs(arrow.getY() - nextNodePos.getY());
		double zDist = Math.abs(arrow.getZ() - (nextNodePos.getZ() + (arrow.getWidth() + 1) / 2D)); //Forge: Fix MC-94054
		boolean flag = xDist <= maxDistanceToWaypoint && zDist <= maxDistanceToWaypoint && yDist < 1.0D; //Forge: Fix MC-94054
		if (flag || /*this.arrow.canCutCorner(this.path.getNextNode().type) && */shouldTargetNextNodeInDirection(tmpPos)) {
			path.next();
		}

		doStuckDetection(tmpPos);
	}

	private boolean shouldTargetNextNodeInDirection(Vec3d curPos) {
		if (path.getCurrentNodeIndex() + 1 >= path.getLength()) {
			return false;
		}
		Vec3d nextNodePos = Vec3d.ofBottomCenter(path.getCurrentNodePos());
		if (!curPos.isInRange(nextNodePos, 2.0D)) {
			return false;
		} else if (canMoveDirectly(curPos, path.getNodePosition(arrow))) {
			return true;
		} else {
			Vec3d afterNextNodePos = Vec3d.ofBottomCenter(path.getNodePos(path.getCurrentNodeIndex() + 1));
			Vec3d nextToAfterNext = afterNextNodePos.subtract(nextNodePos);
			Vec3d curToNext = curPos.subtract(nextNodePos);
			return nextToAfterNext.dotProduct(curToNext) > 0.0D;
		}
	}

	/**
	 * Checks if entity haven't been moved when last checked and if so, clears current {@link
	 * net.minecraft.pathfinding.PathEntity}
	 */
	protected void doStuckDetection(Vec3d curPos) {
		if (tick - lastStuckCheck > 100) {
			if (curPos.squaredDistanceTo(lastStuckCheckPos) < 2.25D) {
				isStuck = true;
				stop();
			} else {
				isStuck = false;
			}

			lastStuckCheck = tick;
			lastStuckCheckPos = curPos;
		}

		if (path != null && !path.isFinished()) {
			Vec3i nextNodePos = path.getCurrentNodePos();
			if (nextNodePos.equals(timeoutCachedNode)) {
				timeoutTimer += Util.getMeasuringTimeMs() - lastTimeoutCheck;
			} else {
				timeoutCachedNode = nextNodePos;
				double distToCacheNode = curPos.distanceTo(Vec3d.ofBottomCenter(timeoutCachedNode));
				timeoutLimit = arrow.getVelocity().length() > 0.0F ? distToCacheNode / arrow.getVelocity().length() * 1000.0D : 0.0D;
			}

			if (timeoutLimit > 0.0D && timeoutTimer > timeoutLimit * 3.0D) {
				timeoutPath();
			}

			lastTimeoutCheck = Util.getMeasuringTimeMs();
		}

	}

	private void timeoutPath() {
		resetStuckTimeout();
		stop();
	}

	private void resetStuckTimeout() {
		timeoutCachedNode = Vec3i.ZERO;
		timeoutTimer = 0;
		timeoutLimit = 0.0;
		isStuck = false;
	}

	/**
	 * If null path or reached the end
	 */
	public boolean isDone() {
		return path == null || path.isFinished();
	}

	public boolean isInProgress() {
		return !isDone();
	}

	/**
	 * sets active PathEntity to null
	 */
	public void stop() {
		path = null;
	}

	protected Vec3d getTempArrowPos() {
		return arrow.getPos();
	}

	/**
	 * If on ground or swimming and can swim
	 */
	protected boolean canUpdatePath() {
		return true;
	}

	/**
	 * Returns true if the entity is in water or lava, false otherwise
	 */
	protected boolean isInLiquid() {
		return arrow.isInsideWaterOrBubbleColumn() || arrow.isInLava();
	}

	/**
	 * Trims path data from the end to the first sun covered block
	 */
	protected void trimPath() {
		if (path != null) {
			for (int i = 0; i < path.getLength(); ++i) {
				PathNode node = path.getNode(i);
				PathNode nextNode = i + 1 < path.getLength() ? path.getNode(i + 1) : null;
				BlockState state = level.getBlockState(new BlockPos(node.x, node.y, node.z));
				if (state.isIn(BlockTags.CAULDRONS)) {
					path.setNode(i, node.copyWithNewPosition(node.x, node.y + 1, node.z));
					if (nextNode != null && node.y >= nextNode.y) {
						path.setNode(i + 1, node.copyWithNewPosition(nextNode.x, node.y + 1, nextNode.z));
					}
				}
			}
		}
	}

	/**
	 * Checks if the specified entity can safely walk to the specified location.
	 */
	protected boolean canMoveDirectly(Vec3d pos1, Vec3d pos2) {
		return false;
	}

	public boolean isStableDestination(BlockPos pos) {
		BlockPos below = pos.down();
		return level.getBlockState(below).isOpaqueFullCube(level, below);
	}

	public PathNodeMaker getNodeEvaluator() {
		return nodeEvaluator;
	}

	public void setCanFloat(boolean canSwim) {
		nodeEvaluator.setCanSwim(canSwim);
	}

	public boolean canFloat() {
		return nodeEvaluator.canSwim();
	}

	public boolean shouldRecomputePath(BlockPos pos) {
		if (hasDelayedRecomputation)
			return false;
		else if (path != null && !path.isFinished() && path.getLength() != 0) {
			PathNode node = path.getEnd();
			Vec3d mid = new Vec3d((node.x + arrow.getX()) / 2.0D, (node.y + arrow.getY()) / 2.0D, (node.z + arrow.getZ()) / 2.0D);
			return pos.isWithinDistance(mid, path.getLength() - path.getCurrentNodeIndex());
		} else
			return false;
		
	}

	public float getMaxDistanceToWaypoint() {
		return maxDistanceToWaypoint;
	}

	public boolean isStuck() {
		return isStuck;
	}
}
