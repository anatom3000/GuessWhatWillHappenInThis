package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.registry.BlockRegistry;
import fr.anatom3000.gwwhit.util.fastnoise.FastNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {

    public FastNoise noise;
    public Random random;

    private float GetTerrainNoise(int x, int y, int z) {
        return noise.GetSimplexFractal(x * 1.25f, y * 2.0f, z * 1.25f) * 5;
    }

    @Inject(at = @At("HEAD"), method = "generateFeatures", cancellable = true)
    public void generateFeatures(ChunkRegion region, StructureAccessor accessor, CallbackInfo info) {

        if (noise == null) {
            noise = new FastNoise((int) region.toServerWorld().getSeed());
            random = new Random(region.toServerWorld().getSeed());
        }

        ChunkPos chunkPos = region.getCenterPos();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int x = chunkPos.getStartX(); x <= chunkPos.getEndX(); x++) {
            for (int z = chunkPos.getStartZ(); z <= chunkPos.getEndZ(); z++) {
                for (int y = region.getBottomY(); y <= region.getTopY(); y++) {
                    if (y >= 252) continue;
                    int cave_biome = (int) (noise.GetCellular(x * 0.5f, y, z * 0.5f) * 10);

                    pos.set(x, y, z);
                    if (region.isChunkLoaded(pos)) {
                        pos.set(x, y - 1, z);

                        if (y <= 20) {
                            if (cave_biome == 0) {
                                pos.set(x, y, z);
                                if (region.getBlockState(pos) == Blocks.STONE.getDefaultState() || region.getBlockState(pos) == Blocks.DEEPSLATE.getDefaultState()) {
                                    region.setBlockState(pos, BlockRegistry.get("mud").getDefaultState(), 0);
                                    pos.set(x, y + 1, z);
                                    if (region.isChunkLoaded(pos))
                                        if (region.getBlockState(pos) == Blocks.AIR.getDefaultState() ||
                                                region.getBlockState(pos) == Blocks.CAVE_AIR.getDefaultState()) {


                                            if (random.nextInt(100) == 0) {
                                                if (random.nextBoolean()) {
                                                    //fungus.grow(region.toServerWorld(), random, pos, Blocks.WARPED_FUNGUS.getDefaultState());

                                                    int height = random.nextInt(5) + 7;
                                                    for (int j = y; j < y + height; j++) {
                                                        pos.set(x, j, z);
                                                    }
                                                    for (int i = -2; i <= +2; i++) {
                                                        for (int j = -2; j <= +2; j++) {
                                                            pos.set(x + i, y + height, z + j);

                                                            if (Math.abs(i) == 2 && Math.abs(j) == 2) {
                                                                if (random.nextInt(4) == 0) continue;
                                                            }

                                                            if (Math.abs(i) == 1 && j == 0 || Math.abs(j) == 1 && i == 0 || i == 0 && j == 0) {
                                                                for (int k = 0; k < 2; k++) {
                                                                    if (i != 0 || j != 0) {
                                                                        if (k == 1) {
                                                                            if (random.nextInt(4) == 0) continue;
                                                                        }
                                                                    }
                                                                    pos.set(x + i, y + height + 1 + k, z + j);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            pos.set(x, y, z);
                                            region.setBlockState(pos, BlockRegistry.get("mushroom_grass").getDefaultState(), 0);
                                        }
                                }
                            } else {
                                if (cave_biome == 1) {
                                    if (region.getBlockState(pos) == Blocks.STONE.getDefaultState() || region.getBlockState(pos) == Blocks.DEEPSLATE.getDefaultState())
                                        region.setBlockState(pos, Blocks.QUARTZ_BLOCK.getDefaultState(), 0);
                                } else {
                                    if (cave_biome == 2) {
                                        if (region.getBlockState(pos) == Blocks.STONE.getDefaultState() || region.getBlockState(pos) == Blocks.DEEPSLATE.getDefaultState())
                                            region.setBlockState(pos, Blocks.GRANITE.getDefaultState(), 0);
                                    } else {
                                        if (cave_biome == 3) {
                                            pos.set(x, y, z);
                                        } else {
                                            if (cave_biome == 4) {
                                                if (region.getBlockState(pos) == Blocks.STONE.getDefaultState() || region.getBlockState(pos) == Blocks.DEEPSLATE.getDefaultState()) {
                                                    pos.set(x, y + 1, z);
                                                    if (region.getBlockState(pos) == Blocks.AIR.getDefaultState() ||
                                                            region.getBlockState(pos) == Blocks.CAVE_AIR.getDefaultState()) {
                                                        if (random.nextInt(10) <= 4) {
                                                            region.setBlockState(pos, Blocks.COBWEB.getDefaultState(), 0);
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}