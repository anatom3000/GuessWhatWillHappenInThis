package fr.anatom3000.gwwhit.materials.lezdor;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class LezdorSword extends SwordItem {
public LezdorSword(ToolMaterial material) {super(material, 2, -1.4444886069788834f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}