package fr.anatom3000.gwwhit.materials.mejesh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class MejeshChestplate extends ArmorItem {
    public MejeshChestplate(ArmorMaterial material) {
        super(material, EquipmentSlot.CHEST, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}