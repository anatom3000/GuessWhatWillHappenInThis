package fr.anatom3000.gwwhit.materials.nejun;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
public class NejunChestplate extends ArmorItem {
public NejunChestplate(ArmorMaterial material) {super(material, EquipmentSlot.CHEST, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}