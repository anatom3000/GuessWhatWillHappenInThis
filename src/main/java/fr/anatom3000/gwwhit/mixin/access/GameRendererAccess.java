package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRenderer.class)
public interface GameRendererAccess {
    @Invoker
    void callLoadShader(Identifier id);
}
