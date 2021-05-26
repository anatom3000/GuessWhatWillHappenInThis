package fr.anatom3000.gwwhit.materials.nizuzc;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class NizuzcChestplate extends ArmorItem {
    public NizuzcChestplate(ArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}