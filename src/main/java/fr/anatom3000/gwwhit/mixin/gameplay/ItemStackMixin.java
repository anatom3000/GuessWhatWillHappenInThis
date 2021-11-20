package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.registry.EnchantmentRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract int getMaxDamage();

    @Shadow
    public abstract NbtList getEnchantments();

    @Shadow
    public abstract void addEnchantment(Enchantment enchantment, int level);

    @Inject(method = "damage(ILjava/util/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z", at = @At("TAIL"))
    private void addCurses(int amount, Random random, ServerPlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        var stack = (ItemStack)(Object)this;

        if (EnchantmentHelper.getLevel(EnchantmentRegistry.CURSE_CURSE, stack) > 0) {
            for (int i=0; i<amount; i++) {
                if (random.nextInt(256) == 0) {
                    var curses = Registry.ENCHANTMENT.stream()
                            .filter(Enchantment::isCursed)
                            .filter(enchantment -> enchantment.isAcceptableItem(stack))
                            .filter(enchantment -> EnchantmentHelper.isCompatible(EnchantmentHelper.fromNbt(getEnchantments()).keySet(), enchantment))
                            .toList();
                    var curse = curses.get(random.nextInt(curses.size()));
                    addEnchantment(curse, 1);
                }
            }
        }
    }
}
