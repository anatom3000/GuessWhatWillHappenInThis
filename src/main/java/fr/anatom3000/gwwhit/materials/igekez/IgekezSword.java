package fr.anatom3000.gwwhit.materials.igekez;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class IgekezSword extends SwordItem {
public IgekezSword(ToolMaterial material) {super(material, 15, -1.9483102233184866f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}