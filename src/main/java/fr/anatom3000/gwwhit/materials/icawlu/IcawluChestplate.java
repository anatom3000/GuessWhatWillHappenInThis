package fr.anatom3000.gwwhit.materials.icawlu;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class IcawluChestplate extends ArmorItem {
    public IcawluChestplate(ArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}