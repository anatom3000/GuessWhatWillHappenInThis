package fr.anatom3000.gwwhit.materials.uberteg;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UbertegHoe extends HoeItem {
public UbertegHoe(ToolMaterial material) {super(material, 6, -1.8434704529331079f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}