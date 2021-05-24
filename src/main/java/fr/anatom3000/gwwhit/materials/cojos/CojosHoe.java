package fr.anatom3000.gwwhit.materials.cojos;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class CojosHoe extends HoeItem {
public CojosHoe(ToolMaterial material) {super(material, 7, -0.6769002401404047f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}