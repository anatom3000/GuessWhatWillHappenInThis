package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.enchantment.CurseCurseEnchantment;
import fr.anatom3000.gwwhit.enchantment.SwappingCurseEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegistry {
    public static final Enchantment SWAPPING_CURSE = new SwappingCurseEnchantment();
    public static final Enchantment CURSE_CURSE = new CurseCurseEnchantment();

    public static void register() {
        Registry.register(Registry.ENCHANTMENT, GWWHIT.getId("swapping_curse"), SWAPPING_CURSE);
        Registry.register(Registry.ENCHANTMENT, GWWHIT.getId("curse_curse"), CURSE_CURSE);
    }
}
