package fr.anatom3000.gwwhit.materials.nefyf;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class NefyfSword extends SwordItem {
public NefyfSword(ToolMaterial material) {super(material, 15, 0.9652609849834933f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}