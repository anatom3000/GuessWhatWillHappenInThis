package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.util.OwoTransformer;
import fr.anatom3000.gwwhit.util.TransformingMap;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.util.Language;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.Map;

@Mixin(Language.class)
public class LanguageMixin {
    private static final MappingResolver mr = FabricLoader.getInstance().getMappingResolver();

    private static final Field FIELD = FieldUtils.getField(TranslationStorage.class,
            mr.mapFieldName("intermediary",
                    "net.minecraft.class_1078",
                    "field_5330",
                    "Ljava/util/Map;"),
            true);

    @Inject(at = @At("HEAD"), method = "setInstance")
    private static void languageSetInstance(Language language, CallbackInfo ci) {
        if (FIELD == null) {
            GuessWhatWillHappenInThisMod.logger.warn("Could not set language map, field not found");
            return;
        }
        if (language instanceof TranslationStorage) {
            try {
                FIELD.set(language, new TransformingMap<String, String>((Map<String, String>) FIELD.get(language), OwoTransformer.TRANSFORMER_SIMPLE));
            } catch (IllegalAccessException | ClassCastException e) {
                e.printStackTrace();
            }
        }
    }

}
