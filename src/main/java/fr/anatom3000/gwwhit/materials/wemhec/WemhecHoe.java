package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WemhecHoe extends HoeItem {
public WemhecHoe(ToolMaterial material) {super(material, 1, 0.46340073107924695f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}