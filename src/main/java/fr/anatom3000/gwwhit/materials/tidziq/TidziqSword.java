package fr.anatom3000.gwwhit.materials.tidziq;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class TidziqSword extends SwordItem {
public TidziqSword(ToolMaterial material) {super(material, 12, -0.39730531281908466f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}