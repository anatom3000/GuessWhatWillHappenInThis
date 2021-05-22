package fr.anatom3000.gwwhit.materials.fydif;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FydifHoe extends HoeItem {
public FydifHoe(ToolMaterial material) {super(material, 7, -1.032121310146803f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}