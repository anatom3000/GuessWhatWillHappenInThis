package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.util.CachingTransformer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.List;
import java.util.ArrayList;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {
    @Inject(at = @At("TAIL"), method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/loot/context/LootContext$Builder;)L;", remap = false)
    public void replaceDroppedStacks(BlockState state, LootContext.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
        cir.getReturnValue().replaceAll(GuessWhatWillHappenInThisMod.itemStackRandomizer);
    }
}
