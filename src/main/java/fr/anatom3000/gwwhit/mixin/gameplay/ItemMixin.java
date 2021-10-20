package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.CustomItemGroups;
import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    private static final FoodComponent DEFAULT_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100), 0.75f)
            .saturationModifier(1)
            .hunger(-5)
            .build();

    @Inject(method = "isFood", at = @At("TAIL"), cancellable = true)
    private void overrideIsFood(CallbackInfoReturnable<Boolean> cir) {
        if (ConfigManager.getActiveConfig().gameplay.items.everythingIsEdible)
            cir.setReturnValue(true);
    }

    @Inject(method = "getFoodComponent", at = @At("TAIL"), cancellable = true)
    private void overrideGetFoodComponent(CallbackInfoReturnable<FoodComponent> cir) {
        if (ConfigManager.getActiveConfig().gameplay.items.everythingIsEdible && cir.getReturnValue() == null)
            cir.setReturnValue(DEFAULT_COMPONENT);
    }

    @Inject(method = "getMaxCount", at = @At("TAIL"), cancellable = true)
    private void overrideGetMaxCount(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(Math.min(cir.getReturnValueI(), ConfigManager.getActiveConfig().gameplay.items.maxStackSize));
    }

    @Inject(method = "getGroup", at = @At("TAIL"), cancellable = true)
    private void overrideGetItemGroup(CallbackInfoReturnable<ItemGroup> cir) {
        if (cir.getReturnValue() == null && ConfigManager.getActiveConfig().gameplay.items.hiddenItemsTab)
            cir.setReturnValue(CustomItemGroups.CURSED_GROUP);
    }
}
