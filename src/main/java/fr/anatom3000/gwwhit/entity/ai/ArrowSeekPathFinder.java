package fr.anatom3000.gwwhit.entity.ai;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathMinHeap;
import net.minecraft.entity.ai.pathing.PathNode;
import net.minecraft.entity.ai.pathing.TargetPathNode;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.profiler.SampleType;
import net.minecraft.world.chunk.ChunkCache;

public class ArrowSeekPathFinder {
	//private static final float FUDGING = 1.5F;
	private final PathNode[] neighbors = new PathNode[32];
	private final int maxNodes;
	private final ArrowSeekNodeEvaluator nodeEval;
	//private static final boolean DEBUG = false;
	private final PathMinHeap nearbyNodes = new PathMinHeap();

	public ArrowSeekPathFinder(ArrowSeekNodeEvaluator nodeEval, int maxNodes) {
		this.nodeEval = nodeEval;
		this.maxNodes = maxNodes;
	}

	/**
	 * Finds a path to one of the specified positions and post-processes it or
	 * returns null if no path could be found within given accuracy
	 */
	@Nullable
	public Path findPath(ChunkCache region, PersistentProjectileEntity arrow, Set<BlockPos> targetPosSet, float maxRange, int accuracy,
			float searchDepthMult) {
		this.nearbyNodes.clear();
		this.nodeEval.prepare(region, arrow);
		PathNode node = this.nodeEval.getStart();
		Map<TargetPathNode, BlockPos> map = targetPosSet.stream().collect(Collectors.toMap((pos) -> {
			return this.nodeEval.getNode((double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
		}, Function.identity()));
		Path path = this.findPath(region.getProfiler(), node, map, maxRange, accuracy, searchDepthMult);
		this.nodeEval.clear();
		return path;
	}

	@Nullable
	private Path findPath(Profiler profiler, PathNode startNode, Map<TargetPathNode, BlockPos> targetPosSet, float maxRange,
			int accuracy, float searchDepthMult) {
		profiler.push("find_path");
		profiler.markSampleType(SampleType.PATH_FINDING);
		Set<TargetPathNode> targets = targetPosSet.keySet();
		startNode.penalizedPathLength = 0;
		startNode.distanceToNearestTarget = ArrowSeekPathFinder.calculateDistances(startNode, targets);
		startNode.heapWeight = startNode.distanceToNearestTarget;
		this.nearbyNodes.clear();
		this.nearbyNodes.push(startNode);
		int i = 0;
		Set<TargetPathNode> newTargets = Sets.newHashSetWithExpectedSize(targets.size());
		int j = (int) (this.maxNodes * searchDepthMult);

		while (!this.nearbyNodes.isEmpty()) {
			++i;
			if (i >= j) {
				break;
			}

			PathNode node = this.nearbyNodes.pop();
			node.visited = true;

			for (TargetPathNode target : targets) {
				if (node.getManhattanDistance(target) <= accuracy) {
					target.markReached();
					newTargets.add(target);
				}
			}

			if (!newTargets.isEmpty()) {
				break;
			}

			if (!(node.getDistance(startNode) >= maxRange)) {
				int k = this.nodeEval.getSuccessors(this.neighbors, node);

				for (int l = 0; l < k; ++l) {
					PathNode adjNode = this.neighbors[l];
					float distToAdj = node.getDistance(adjNode);
					adjNode.pathLength = node.pathLength + distToAdj;
					float newTotalCost = node.penalizedPathLength + distToAdj + adjNode.penalty;
					if (adjNode.pathLength < maxRange && (!adjNode.isInHeap() || newTotalCost < adjNode.penalizedPathLength)) {
						adjNode.previous = node;
						adjNode.penalizedPathLength = newTotalCost;
						adjNode.distanceToNearestTarget = ArrowSeekPathFinder.calculateDistances(adjNode, targets) * 1.5f;
						if (adjNode.isInHeap()) {
							this.nearbyNodes.setNodeWeight(adjNode, adjNode.penalizedPathLength + adjNode.distanceToNearestTarget);
						} else {
							adjNode.heapWeight = adjNode.penalizedPathLength + adjNode.distanceToNearestTarget;
							this.nearbyNodes.push(adjNode);
						}
					}
				}
			}
		}

		Optional<Path> optPath = !newTargets.isEmpty() ? newTargets.stream().map((targ) -> {
			return ArrowSeekPathFinder.reconstructPath(targ.getNearestNode(), targetPosSet.get(targ), true);
		}).min(Comparator.comparingInt(Path::getLength)) : targets.stream().map((targ) -> {
			return ArrowSeekPathFinder.reconstructPath(targ.getNearestNode(), targetPosSet.get(targ), false);
		}).min(Comparator.comparingDouble(Path::getLength).thenComparingInt(Path::getLength));
		profiler.pop();
		return !optPath.isPresent() ? null : optPath.get();
	}

	private static float calculateDistances(PathNode pNode, Set<TargetPathNode> pTargets) {
		float estCost = Float.MAX_VALUE;

		for (TargetPathNode target : pTargets) {
			float newEstCost = pNode.getDistance(target);
			target.updateNearestNode(newEstCost, pNode);
			estCost = Math.min(newEstCost, estCost);
		}

		return estCost;
	}

	/**
	 * Converts a recursive path point structure into a path
	 */
	private static Path reconstructPath(PathNode startNode, BlockPos targetPos, boolean complete) {
		List<PathNode> nodes = Lists.newArrayList();
		PathNode node = startNode;
		nodes.add(0, startNode);

		while (node.previous != null) {
			node = node.previous;
			nodes.add(0, node);
		}

		return new Path(nodes, targetPos, complete);
	}
}