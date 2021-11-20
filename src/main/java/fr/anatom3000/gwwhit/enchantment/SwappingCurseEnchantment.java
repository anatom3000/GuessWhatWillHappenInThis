package fr.anatom3000.gwwhit.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class SwappingCurseEnchantment extends Enchantment {
    public SwappingCurseEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[0]);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity le) {
            ItemStack targetStack = le.getMainHandStack();
            ItemStack userStack = user.getMainHandStack();
            le.equipStack(EquipmentSlot.MAINHAND, userStack);
            if (le instanceof MobEntity mob) mob.updateDropChances(EquipmentSlot.MAINHAND);
            user.equipStack(EquipmentSlot.MAINHAND, targetStack);
            if (user instanceof MobEntity mob) mob.updateDropChances(EquipmentSlot.MAINHAND);
        }
    }

    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }
}
