package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.client.resource.language.TranslationStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(TranslationStorage.class)
public interface TranslationStorageAccessor {
    @Accessor("translations")
    Map<String, String> getTranslations();

    @Mutable
    @Accessor("translations")
    void setTranslations(Map<String, String> translations);
}
