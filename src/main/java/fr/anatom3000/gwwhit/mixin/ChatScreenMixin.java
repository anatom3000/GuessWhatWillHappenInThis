package fr.anatom3000.gwwhit.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import fr.anatom3000.gwwhit.util.OwoTransformer;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Shadow
    protected TextFieldWidget chatField;

    @Inject(at = @At("RETURN"), method = "keyPressed(III)Z")
    private void modifyScreen(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> info) {
        if (chatField != null && !chatField.getText().startsWith("/")) {
            chatField.setText(OwoTransformer.TRANSFORMER_SIMPLE.apply(chatField.getText()));
        }
    }
}
