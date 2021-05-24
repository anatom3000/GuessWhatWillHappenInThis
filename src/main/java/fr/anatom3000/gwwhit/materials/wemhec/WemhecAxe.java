package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WemhecAxe extends AxeItem {
public WemhecAxe(ToolMaterial material) {super(material, 6, -1.5823467132663538f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}