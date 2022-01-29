package fr.anatom3000.gwwhit.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.NoiseColumnSampler;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.chunk.VerticalBlockSample;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public class RandomChunkGenerator extends ChunkGenerator {
    public static final Codec<RandomChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> instance
            .group(BiomeSource.CODEC.fieldOf("biome_source").forGetter((generator) -> generator.biomeSource))
            .apply(instance, instance.stable(RandomChunkGenerator::new)));
    public final List<Block> whitelistedBlocks;
    private final Random random;

    public RandomChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource, new StructuresConfig(false));
        this.random = new Random();
        this.whitelistedBlocks = Registry.BLOCK
                .getIds()
                .stream()
                .map(Registry.BLOCK::get)
                .filter(block -> block.getClass() == Block.class)
                .collect(Collectors.toList());
    }

    public RandomChunkGenerator(BiomeSource biomeSource, long seed) {
        super(biomeSource, new StructuresConfig(false));
        this.random = new Random(seed);
        this.whitelistedBlocks = Registry.BLOCK
                .getIds()
                .stream()
                .map(Registry.BLOCK::get)
                .filter(block -> block.getClass() == Block.class)
                .collect(Collectors.toList());
    }

    @Override
    protected Codec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public ChunkGenerator withSeed(long seed) {
        return this;
    }

    @Override
    public MultiNoiseUtil.MultiNoiseSampler getMultiNoiseSampler() {
        return new RandomNoiseSampler();
    }

    @Override
    public void carve(ChunkRegion chunkRegion, long seed, BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk, GenerationStep.Carver generationStep) {
    }

    @Override
    public void buildSurface(ChunkRegion region, StructureAccessor structures, Chunk chunk) {
    }

    @Override
    public void populateEntities(ChunkRegion region) {
    }

    @Override
    public int getWorldHeight() {
        return 256;
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Executor executor, Blender blender, StructureAccessor structureAccessor, Chunk chunk) {
        BlockPos.Mutable posMutable = new BlockPos.Mutable();
        return CompletableFuture.supplyAsync(() -> {
            for (int x = 0; x < 16; ++x) {
                posMutable.setX(x);
                for (int z = 0; z < 16; ++z) {
                    posMutable.setZ(z);
                    for (int y = 0; y < 50; ++y) {
                        posMutable.setY(y);
                        chunk.setBlockState(posMutable, whitelistedBlocks.get(random.nextInt(whitelistedBlocks.size())).getDefaultState(), false);
                    }
                }
            }
            return chunk;
        });
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public int getMinimumY() {
        return 0;
    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmapType, HeightLimitView heightLimitView) {
        return 51;
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView heightLimitView) {
        return new VerticalBlockSample(0, new BlockState[0]);
    }
}
