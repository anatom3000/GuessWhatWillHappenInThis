package fr.anatom3000.gwwhit.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.chunk.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Mixin(ChunkGeneratorSettings.class)
public class ChunkGeneratorSettingsMixin {
    
    @Inject(at = @At("HEAD"), method = "createSurfaceSettings", cancellable = true)
    private static void createSurfaceSettings(StructuresConfig structuresConfig, boolean amplified, CallbackInfoReturnable<ChunkGeneratorSettings> info) {
        
        Constructor<?> construct = ChunkGeneratorSettings.class.getDeclaredConstructors()[0];

        construct.setAccessible(true);
        
        ChunkGeneratorSettings settings;
        try {
            settings = (ChunkGeneratorSettings) construct.newInstance(
                    structuresConfig,
                    GenerationShapeConfig.create(
                            -256,
                            384,
                            new NoiseSamplingConfig(
                                    0.9999999814507745D,
                                    0.9999999814507745D,
                                    80.0D,
                                    160.0D
                            ),
                            new SlideConfig(
                                    -10,
                                    3,
                                    0
                            ),
                            new SlideConfig(
                                    15,
                                    3,
                                    0),
                            1,
                            2,
                            1.0D,
                            -0.46875D,
                            true,
                            true,
                            false,
                            amplified
                    ),
                    // defaultBlock
                    Blocks.STONE.getDefaultState(),
                    // defaultFluid
                    Blocks.WATER.getDefaultState(),
                    // bedrockCeilingY
                    -2147483648,
                    // bedrockFloorY
                    -255,
                    // seaLevel
                    63,
                    // minSurfaceLevel
                    40,
                    // mobGenerationDisabled
                    false,
                    // aquifers
                    false,
                    // noiseCaves
                    false,
                    // deepslate
                    false,
                    // oreVeins
                    false,
                    // noodleCaves
                    false
            );
            
            info.setReturnValue(settings);
        } catch (InstantiationException | IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    
    }
}