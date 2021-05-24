package fr.anatom3000.gwwhit.materials.igekez;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class IgekezHelmet extends ArmorItem {
public IgekezHelmet(ArmorMaterial material) {super(material, EquipmentSlot.HEAD, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}