package fr.anatom3000.gwwhit.block.entity;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

public class MulticolorBlockEntityRenderer implements BlockEntityRenderer<MulticolorBlockEntity> {

    public MulticolorBlockEntityRenderer( BlockEntityRendererFactory.Context ctx ) {}

    @Override
    public void render(
            MulticolorBlockEntity entity,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            int overlay
    ) {
        matrices.push();
        MinecraftClient.getInstance()
                .getBlockRenderManager()
                .renderBlock(
                        entity.getCachedState(),
                        entity.getPos(),
                        entity.getWorld(),
                        matrices,
                        vertexConsumers.getBuffer( RenderLayer.getSolid() ),
                        false,
                        entity.getRandom()
                );
        matrices.pop();
    }
}
