package fr.anatom3000.gwwhit.materials.soneg;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class SonegSword extends SwordItem {
public SonegSword(ToolMaterial material) {super(material, 4, 0.18757167995783686f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}