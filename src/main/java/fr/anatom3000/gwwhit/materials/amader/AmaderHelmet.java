package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class AmaderHelmet extends ArmorItem {
public AmaderHelmet(ArmorMaterial material) {super(material, EquipmentSlot.HEAD, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}