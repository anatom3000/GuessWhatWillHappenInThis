package fr.anatom3000.gwwhit.materials.tefa;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class TefaSword extends SwordItem {
public TefaSword(ToolMaterial material) {super(material, 2, -0.15923304447318065f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}