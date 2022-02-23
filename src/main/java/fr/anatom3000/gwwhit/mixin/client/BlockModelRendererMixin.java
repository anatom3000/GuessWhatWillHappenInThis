package fr.anatom3000.gwwhit.mixin.client;

import fr.anatom3000.gwwhit.block.MulticoloredBlock;
import fr.anatom3000.gwwhit.block.entity.MulticolorBlockEntity;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockModelRenderer.class)
public class BlockModelRendererMixin {

    @Inject(
            method = "renderQuad(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/model/BakedQuad;FFFFIIIII)V",
            at = @At( "HEAD" ),
            cancellable = true
    )
    void onRenderQuad(
            BlockRenderView world,
            BlockState state,
            BlockPos pos,
            VertexConsumer vertexConsumer,
            MatrixStack.Entry matrixEntry,
            BakedQuad quad,
            float brightness0,
            float brightness1,
            float brightness2,
            float brightness3,
            int light0,
            int light1,
            int light2,
            int light3,
            int overlay,
            CallbackInfo info
    ) {
        if ( state.getBlock() instanceof MulticoloredBlock ) {
            // its our block, cancel the actual method!
            info.cancel();
            // get block color
            var color = world.getBlockEntity(
                    pos,
                    BlockEntityRegistry.MULTICOLOR_BLOCK_ENTITY
            ).orElseThrow().getColor();
            // render block
            vertexConsumer.quad(
                    matrixEntry,
                    quad,
                    new float[]{brightness0, brightness1, brightness2, brightness3},
                    color.getFloatRed(),
                    color.getFloatGreen(),
                    color.getFloatBlue(),
                    new int[]{light0, light1, light2, light3},
                    overlay,
                    true
            );
        }
    }
}
