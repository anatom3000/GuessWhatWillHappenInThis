package fr.anatom3000.gwwhit.materials.igekez;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class IgekezSword extends SwordItem {
public IgekezSword(ToolMaterial material) {super(material, 15, -1.9483102233184866f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}