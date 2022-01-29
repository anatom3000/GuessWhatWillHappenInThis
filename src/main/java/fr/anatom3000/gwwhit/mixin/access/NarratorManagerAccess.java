package fr.anatom3000.gwwhit.mixin.access;

import com.mojang.text2speech.Narrator;
import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NarratorManager.class)
public interface NarratorManagerAccess {
    @Accessor
    Narrator getNarrator();
}
