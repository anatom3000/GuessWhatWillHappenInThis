package fr.anatom3000.gwwhit.materials.luqysk;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class LuqyskLeggings extends ArmorItem {
public LuqyskLeggings(ArmorMaterial material) {super(material, EquipmentSlot.LEGS, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}