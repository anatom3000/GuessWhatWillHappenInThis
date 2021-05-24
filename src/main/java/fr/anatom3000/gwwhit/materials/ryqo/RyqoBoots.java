package fr.anatom3000.gwwhit.materials.ryqo;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class RyqoBoots extends ArmorItem {
public RyqoBoots(ArmorMaterial material) {super(material, EquipmentSlot.FEET, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}