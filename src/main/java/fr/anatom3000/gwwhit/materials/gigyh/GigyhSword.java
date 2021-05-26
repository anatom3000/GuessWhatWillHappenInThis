package fr.anatom3000.gwwhit.materials.gigyh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class GigyhSword extends SwordItem {
public GigyhSword(ToolMaterial material) {super(material, 10, 0.3801469557694177f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}