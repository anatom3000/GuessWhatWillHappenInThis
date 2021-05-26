package fr.anatom3000.gwwhit.materials.loded;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
public class LodedHoe extends HoeItem {
public LodedHoe(ToolMaterial material) {super(material, 1, -1.3154065086412352f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}