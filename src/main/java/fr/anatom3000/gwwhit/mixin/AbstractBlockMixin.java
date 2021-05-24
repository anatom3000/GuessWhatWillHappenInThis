package fr.anatom3000.gwwhit.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {
    @Inject(at = @At("TAIL"), method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/loot/context/LootContext$Builder;)L;", remap = false)
    public void replaceDroppedStacks(BlockState state, LootContext.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
        /*
        Commented out and disabled in mixin config because it crashes
        Once fixed please uncomment the config key
        
        if (Config.getLoadedConfig().getValue(Config.RANDOM_DROPS_ENABLED_KEY)) {
            cir.getReturnValue().replaceAll(GuessWhatWillHappenInThisMod.itemStackRandomizer);
        }
         */
    }
}
