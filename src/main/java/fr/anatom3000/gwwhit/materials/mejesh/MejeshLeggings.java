package fr.anatom3000.gwwhit.materials.mejesh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class MejeshLeggings extends ArmorItem {
    public MejeshLeggings(ArmorMaterial material) {
        super(material, EquipmentSlot.LEGS, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}