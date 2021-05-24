package fr.anatom3000.gwwhit.materials.wekmal;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WekmalSword extends SwordItem {
public WekmalSword(ToolMaterial material) {super(material, 15, -0.13963772885315429f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}