package fr.anatom3000.gwwhit.model;

import fr.anatom3000.gwwhit.util.Color;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.fabricmc.fabric.api.rendering.data.v1.RenderAttachedBlockView;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class MulticolorBakedModel implements BakedModel, FabricBakedModel {
    public static final Object LOCK = new Object();
    private final Mesh mesh;
    private final ModelTransformation transformation;
    private final Sprite sprite;

    public MulticolorBakedModel( Mesh mesh, ModelTransformation transformation, Sprite sprite ) {
        this.mesh = mesh;
        this.transformation = transformation;
        this.sprite = sprite;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public void emitBlockQuads( BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> supplier, RenderContext ctx ) {
        if ( blockView instanceof RenderAttachedBlockView view ) {
            final Color color = (Color) view.getBlockEntityRenderAttachment( pos );
            assert color != null;
            ctx.pushTransform(
                    quad -> {
                        quad.spriteColor(
                                0,
                                color.getUnifiedColor(),
                                color.getUnifiedColor(),
                                color.getUnifiedColor(),
                                color.getUnifiedColor()
                        );
                        return true;
                    }
            );
            ctx.meshConsumer().accept(mesh);
            ctx.popTransform();
        }
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> supplier, RenderContext ctx) {
        final Color color = new Color( stack.getOrCreateNbt() );
        ctx.pushTransform(
                quad -> {
                    quad.spriteColor(
                            0,
                            color.getUnifiedColor(),
                            color.getUnifiedColor(),
                            color.getUnifiedColor(),
                            color.getUnifiedColor()
                    );
                    return true;
                }
        );
        ctx.meshConsumer().accept(mesh);
        ctx.popTransform();
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return true;
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public Sprite getParticleSprite() {
        return sprite;
    }

    @Override
    public ModelTransformation getTransformation() {
        return transformation;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return ModelOverrideList.EMPTY;
    }
}
