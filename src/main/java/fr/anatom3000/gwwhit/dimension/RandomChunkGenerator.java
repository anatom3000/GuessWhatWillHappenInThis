package fr.anatom3000.gwwhit.dimension;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.chunk.VerticalBlockSample;

public class RandomChunkGenerator extends ChunkGenerator {

    private final Random random;

    public static List<Block> whitelistedBlocks = Registry.BLOCK
        .getIds()
        .stream()
        .map(Registry.BLOCK::get)
        .filter(block -> block.getClass() == Block.class)
        .collect(Collectors.toList());

    public static final Codec<RandomChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> instance
            .group(BiomeSource.CODEC.fieldOf("biome_source").forGetter((generator) -> generator.biomeSource))
            .apply(instance, instance.stable(RandomChunkGenerator::new)));

    public RandomChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource, new StructuresConfig(false));
        this.random = new Random();
    }

    public RandomChunkGenerator(BiomeSource biomeSource, long seed) {
        super(biomeSource, new StructuresConfig(false));
        this.random = new Random(seed);
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
    public void buildSurface(ChunkRegion region, Chunk chunk) {
    }


    @Override
    public CompletableFuture<Chunk> populateNoise(Executor executor, StructureAccessor accessor, Chunk chunk) {
        List<Identifier> ids = Registry.BLOCK.getIds().stream().collect(Collectors.toList());
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
    public int getHeight(int x, int z, Heightmap.Type heightmapType, HeightLimitView heightLimitView) {
        return 51;
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView heightLimitView) {
        return new VerticalBlockSample(0, new BlockState[0]);
    }

}
