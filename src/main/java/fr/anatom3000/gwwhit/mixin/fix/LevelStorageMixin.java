package fr.anatom3000.gwwhit.mixin.fix;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFixer;
import com.mojang.serialization.Dynamic;
import fr.anatom3000.gwwhit.GWWHIT;
import net.minecraft.SharedConstants;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtInt;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LevelStorage.class)
public class LevelStorageMixin {
    @Redirect(method = "method_29582(Lcom/mojang/serialization/DynamicOps;Lnet/minecraft/resource/DataPackSettings;Lcom/mojang/serialization/Lifecycle;Ljava/io/File;Lcom/mojang/datafixers/DataFixer;)Lnet/minecraft/world/level/LevelProperties;", at = @At(value = "INVOKE", target = "Lcom/mojang/datafixers/DataFixer;update(Lcom/mojang/datafixers/DSL$TypeReference;Lcom/mojang/serialization/Dynamic;II)Lcom/mojang/serialization/Dynamic;"))
    private static Dynamic<NbtCompound> gwwhit$deferUpdate(DataFixer fixer, DSL.TypeReference type, Dynamic<NbtCompound> input, int version, int newVersion) {
        return fixer.update(type, input.map(LevelStorageMixin::gwwhit$transform), version, newVersion);
    }

    @Redirect(method = "method_29015(Ljava/io/File;ZLjava/io/File;Lcom/mojang/datafixers/DataFixer;)Lnet/minecraft/world/level/storage/LevelSummary;", at = @At(value = "INVOKE", target = "Lcom/mojang/datafixers/DataFixer;update(Lcom/mojang/datafixers/DSL$TypeReference;Lcom/mojang/serialization/Dynamic;II)Lcom/mojang/serialization/Dynamic;"))
    private Dynamic<NbtCompound> gwwhit$deferUpdate2(DataFixer fixer, DSL.TypeReference type, Dynamic<NbtCompound> input, int version, int newVersion) {
        return fixer.update(type, input.map(LevelStorageMixin::gwwhit$transform), version, newVersion);
    }

    private static NbtCompound gwwhit$transform(NbtCompound levelData) {
        boolean update = true;
        if (levelData.get("DataVersion") instanceof NbtInt dataVersion) {
            update = dataVersion.intValue() != SharedConstants.getGameVersion().getWorldVersion();
        } else GWWHIT.LOGGER.error("Could not get DataVersion int, assuming outdated");
        if (update) {
            if (levelData.get("WorldGenSettings") instanceof NbtCompound worldGenSettings) {
                if (worldGenSettings.get("dimensions") instanceof NbtCompound dimensions) {
                    final String dimensionId = GWWHIT.getId("random").toString();
                    if (dimensions.get(dimensionId) instanceof NbtCompound) {
                        dimensions.remove(dimensionId);
                    } else GWWHIT.LOGGER.error("Could not get gwwhit dimension compound in " + dimensions);
                } else GWWHIT.LOGGER.error("Could not get dimensions compound in " + worldGenSettings);
            } else GWWHIT.LOGGER.error("Could not get WorldGenSettings compound in " + levelData);
        }
        return levelData;
    }
}
