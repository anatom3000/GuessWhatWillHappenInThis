package fr.anatom3000.gwwhit.materials.notic;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class NoticBoots extends ArmorItem {
public NoticBoots(ArmorMaterial material) {super(material, EquipmentSlot.FEET, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}