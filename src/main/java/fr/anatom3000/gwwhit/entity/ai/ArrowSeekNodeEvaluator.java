package fr.anatom3000.gwwhit.entity.ai;

import javax.annotation.Nullable;

import fr.anatom3000.gwwhit.entity.projectile.SentientArrow;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.PathNode;
import net.minecraft.entity.ai.pathing.PathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.TargetPathNode;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.chunk.ChunkCache;

public class ArrowSeekNodeEvaluator extends PathNodeMaker {

	public PersistentProjectileEntity arrow;
	public LivingEntity target;

	public ArrowSeekNodeEvaluator() {
	}

	public void prepare(ChunkCache level, PersistentProjectileEntity arrow) {
		this.cachedWorld = level;
		this.arrow = arrow;
		this.pathNodeCache.clear();
		this.entityBlockXSize = MathHelper.floor(arrow.getWidth() + 1);
		this.entityBlockYSize = MathHelper.floor(arrow.getHeight() + 1);
		this.entityBlockZSize = MathHelper.floor(arrow.getWidth() + 1);
	}

	@Override
	public PathNode getStart() {
		BlockPos pos = this.arrow.getBlockPos();
		return super.getNode(pos);
	}

	@Override
	public TargetPathNode getNode(double x, double y, double z) {
		return new TargetPathNode(super.getNode(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z)));
	}

	@Override
	@Nullable
	protected PathNode getNode(int x, int y, int z) {
		PathNode node = super.getNode(x, y, z);

		BlockPos.Mutable mBlockPos = new BlockPos.Mutable();
		PathNodeType blockPathTypes = getBlockPathTypeRaw(this.cachedWorld, mBlockPos.set(x, y, z));
		if (blockPathTypes != PathNodeType.OPEN) {
			node.visited = true;
		}
		return node;
	}

	@Override
	public int getSuccessors(PathNode[] neighbours, PathNode thisNode) {
		int i = 0;
		PathNode south = this.getNode(thisNode.x, thisNode.y, thisNode.z + 1);
		if (ArrowSeekNodeEvaluator.isOpen(south)) {
			neighbours[i++] = south;
		}

		PathNode west = this.getNode(thisNode.x - 1, thisNode.y, thisNode.z);
		if (ArrowSeekNodeEvaluator.isOpen(west)) {
			neighbours[i++] = west;
		}

		PathNode east = this.getNode(thisNode.x + 1, thisNode.y, thisNode.z);
		if (ArrowSeekNodeEvaluator.isOpen(east)) {
			neighbours[i++] = east;
		}

		PathNode north = this.getNode(thisNode.x, thisNode.y, thisNode.z - 1);
		if (ArrowSeekNodeEvaluator.isOpen(north)) {
			neighbours[i++] = north;
		}

		PathNode above = this.getNode(thisNode.x, thisNode.y + 1, thisNode.z);
		if (ArrowSeekNodeEvaluator.isOpen(above)) {
			neighbours[i++] = above;
		}

		PathNode below = this.getNode(thisNode.x, thisNode.y - 1, thisNode.z);
		if (ArrowSeekNodeEvaluator.isOpen(below)) {
			neighbours[i++] = below;
		}

		return i;
	}

	private static boolean isOpen(@Nullable PathNode node) {
		return node != null && !node.visited;
	}

	public static PathNodeType getBlockPathTypeRaw(BlockView level, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		if (state.isAir() || SentientArrow.canNoclipThrough(state)) {
			return PathNodeType.OPEN;
		}
		return PathNodeType.BLOCKED;
	}

	@Override
	public PathNodeType getNodeType(BlockView level, int x, int y, int z, MobEntity mob,
			int xSize, int ySize, int zSize, boolean canBreakDoor, boolean canOpenDoor) {
		return null;
	}

	@Override
	public PathNodeType getDefaultNodeType(BlockView level, int x, int y, int z) {
		return null;
	}
}
