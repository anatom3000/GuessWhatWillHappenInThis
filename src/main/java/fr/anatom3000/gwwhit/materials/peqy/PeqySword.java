package fr.anatom3000.gwwhit.materials.peqy;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class PeqySword extends SwordItem {
public PeqySword(ToolMaterial material) {super(material, 5, -0.07874151318768918f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}