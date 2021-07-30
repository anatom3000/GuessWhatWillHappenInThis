package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LootManager.class)
public class LootManagerMixin {
    @Shadow
    private Map<Identifier, LootTable> tables;

    @Inject(at = @At("HEAD"), method = "getTable(Lnet/minecraft/util/Identifier;)Lnet/minecraft/loot/LootTable;", cancellable = true)
    private void randomizeTable(Identifier id, CallbackInfoReturnable<LootTable> cir) {
        if (ConfigManager.getLoadedConfig().gameplay.drops.randomizedDrops && tables.containsKey(id)) {
            cir.setReturnValue(tables.get(GWWHIT.TABLE_RANDOMIZER.apply(id, tables)));
        }
    }
}
