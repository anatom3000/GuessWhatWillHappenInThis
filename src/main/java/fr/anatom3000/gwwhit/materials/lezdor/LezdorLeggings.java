package fr.anatom3000.gwwhit.materials.lezdor;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class LezdorLeggings extends ArmorItem {
public LezdorLeggings(ArmorMaterial material) {super(material, EquipmentSlot.LEGS, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}