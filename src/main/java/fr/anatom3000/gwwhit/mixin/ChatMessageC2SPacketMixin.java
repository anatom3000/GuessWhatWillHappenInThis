package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.util.OwoTransformer;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatMessageC2SPacket.class)
public class ChatMessageC2SPacketMixin {
    @Mutable @Final @Shadow private String chatMessage;

    @Inject(at = @At("RETURN"), method = "<init>(Ljava/lang/String;)V")
    public void init(String chatMessage, CallbackInfo info) {
        if (!chatMessage.startsWith("/")) {
            OwoTransformer transformer = chatMessage.length() < 5
                    ? OwoTransformer.TRANSFORMER_SIMPLE
                    : chatMessage.length() < 20
                    ? OwoTransformer.TRANSFORMER_PREFIX
                    : OwoTransformer.TRANSFORMER_FULL;
            chatMessage = transformer.apply(chatMessage);
        }

        if (chatMessage.length() > 256) {
            chatMessage = chatMessage.substring(0, 256);
        }

        this.chatMessage = chatMessage;
    }
}
