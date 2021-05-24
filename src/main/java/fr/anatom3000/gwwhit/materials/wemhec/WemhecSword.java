package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WemhecSword extends SwordItem {
public WemhecSword(ToolMaterial material) {super(material, 12, 0.705023741302216f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}