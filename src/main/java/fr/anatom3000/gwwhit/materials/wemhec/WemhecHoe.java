package fr.anatom3000.gwwhit.materials.wemhec;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
public class WemhecHoe extends HoeItem {
public WemhecHoe(ToolMaterial material) {super(material, 1, 0.46340073107924695f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}