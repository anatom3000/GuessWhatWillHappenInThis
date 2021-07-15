package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.util.RomanUtil;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

	@Redirect(
			method = "renderGuiItemOverlay(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V",
			at = @At(value = "INVOKE", target = "Ljava/lang/String;valueOf(I)Ljava/lang/String;")
	)
	private String render(int i) {
		if ( ConfigManager.getLoadedConfig().cosmetic.rendering.itemUseRomanNumerals ) {
			return RomanUtil.toRoman(i);
		}
		return String.valueOf(i);
	}

	@Redirect(
			method = "renderGuiItemOverlay(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V",
			at = @At (value = "INVOKE", target = "Lnet/minecraft/client/font/TextRenderer;getWidth(Ljava/lang/String;)I")
	)
	private int width(TextRenderer renderer, String text) {
		if ( ConfigManager.getLoadedConfig().cosmetic.rendering.itemUseRomanNumerals ) {
			return (int) ( renderer.getWidth(text) * RomanUtil.getScale(text) );
		}
		return renderer.getWidth(text);
	}

	@Inject(
			method = "renderGuiItemOverlay(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V",
			at = @At (value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V", shift = At.Shift.AFTER),
			locals = LocalCapture.CAPTURE_FAILHARD
	)
	private void rescaleText(TextRenderer fontRenderer, ItemStack stack, int x, int y, String amountText, CallbackInfo ci, MatrixStack matrixStack, String string) {
		if ( ConfigManager.getLoadedConfig().cosmetic.rendering.itemUseRomanNumerals ) {
			float f = RomanUtil.getScale(string);
			if (f != 1f) {
				matrixStack.translate(x * (1 - f), y * (1 - f) + (1 - f) * 16, 0);
				matrixStack.scale(f, f, f);
			}
		}
	}
}
