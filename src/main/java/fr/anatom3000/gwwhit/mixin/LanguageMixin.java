package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.util.OwoTransformer;
import fr.anatom3000.gwwhit.util.TransformingMap;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Language.class)
public class LanguageMixin {
    @Inject(at = @At("HEAD"), method = "setInstance")
    private static void languageSetInstance(Language language, CallbackInfo ci) {
        if (language instanceof TranslationStorage t) {
            TranslationStorageAccessor ta = (TranslationStorageAccessor) t;
            ta.setTranslations(new TransformingMap<>(ta.getTranslations(), OwoTransformer.TRANSFORMER_SIMPLE));
        }
    }
}
