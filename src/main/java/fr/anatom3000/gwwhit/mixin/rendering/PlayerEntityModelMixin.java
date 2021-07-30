package fr.anatom3000.gwwhit.mixin.rendering;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin<T extends LivingEntity> extends BipedEntityModel<T> {
    @Shadow
    @Final
    private ModelPart ear;

    public PlayerEntityModelMixin(ModelPart root) {
        super(root);
    }

    @Inject(method = "renderEars", at = @At(value = "HEAD"), cancellable = true)
    private void earRenderFix(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, CallbackInfo ci) {
        ear.copyTransform(this.head);
        ear.pivotX = 0;
        ear.render(matrices, vertices, light, overlay);
        ci.cancel();
    }
}
