package fr.anatom3000.gwwhit.materials.gigyh;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class GigyhSword extends SwordItem {
public GigyhSword(ToolMaterial material) {super(material, 10, 0.3801469557694177f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}