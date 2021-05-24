package fr.anatom3000.gwwhit.materials.tetus;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class TetusSword extends SwordItem {
public TetusSword(ToolMaterial material) {super(material, 13, -1.5987746040331299f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}