package fr.anatom3000.gwwhit.dimension;

import fr.anatom3000.gwwhit.GWWHIT;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

public class RandomNoiseSampler implements MultiNoiseUtil.MultiNoiseSampler {
    @Override
    public MultiNoiseUtil.NoiseValuePoint sample(int x, int y, int z) {
        return new MultiNoiseUtil.NoiseValuePoint(
                GWWHIT.RANDOM.nextLong(),
                GWWHIT.RANDOM.nextLong(),
                GWWHIT.RANDOM.nextLong(),
                GWWHIT.RANDOM.nextLong(),
                GWWHIT.RANDOM.nextLong(),
                GWWHIT.RANDOM.nextLong()
        );
    }
}
