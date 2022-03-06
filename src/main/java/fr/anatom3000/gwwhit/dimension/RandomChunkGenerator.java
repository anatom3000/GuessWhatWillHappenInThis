package fr.anatom3000.gwwhit.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

public class RandomChunkGenerator extends ChunkGenerator {
    public static final Codec<RandomChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            method_41042(instance)
                    .and(RegistryOps.createRegistryCodec(Registry.BIOME_KEY).forGetter(gen -> gen.biomeRegistry))
                    .apply(instance, instance.stable(RandomChunkGenerator::new))
    );
    public final List<Block> whitelistedBlocks;
    private final Random random;
    private final Registry<Biome> biomeRegistry;

    public RandomChunkGenerator(Registry<StructureSet> registry, Registry<Biome> registry2) {
        super(registry, Optional.empty(), new FixedBiomeSource(registry2.getOrCreateEntry(BiomeKeys.PLAINS)));
        this.random = new Random();
        this.whitelistedBlocks = Registry.BLOCK
                .getIds()
                .stream()
                .map(Registry.BLOCK::get)
                .filter(block -> block.getClass() == Block.class)
                .collect(Collectors.toList());
        this.biomeRegistry = registry2;
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
        return MultiNoiseUtil.method_40443();
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

    @Override
    public void getDebugHudText(List<String> text, BlockPos pos) {
        text.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ut tempus ipsum, luctus tincidunt diam. Vestibulum sed sollicitudin lectus. Nulla pretium congue lacinia. Quisque iaculis ligula nunc, sit amet cursus nisi pellentesque in. Curabitur sagittis felis scelerisque neque pharetra, imperdiet pulvinar eros egestas. Integer rhoncus nibh nec urna vulputate volutpat. In suscipit urna justo, in gravida lacus pretium eu. Quisque volutpat et sem varius varius. Fusce consectetur in nisl ac facilisis. Suspendisse potenti. Mauris sed ex ut erat malesuada facilisis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec vulputate molestie turpis id sollicitudin. Integer tempus felis eget est ultrices luctus. Sed ultrices elit fringilla tristique tincidunt.");
        text.add("Donec commodo aliquam ex sit amet rhoncus. Praesent nibh nunc, maximus a vehicula id, pretium id tellus. Donec eleifend finibus tristique. Sed eget aliquam felis, id placerat odio. Proin vitae neque porta mauris fermentum ornare. Quisque vulputate mi ac turpis vulputate, nec interdum ipsum facilisis. Aliquam leo eros, hendrerit et ornare sit amet, tempus vitae magna. Pellentesque pulvinar ultricies felis, ornare cursus turpis congue id.");
    }
}
