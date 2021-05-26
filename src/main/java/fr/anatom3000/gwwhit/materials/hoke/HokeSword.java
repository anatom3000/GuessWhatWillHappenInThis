package fr.anatom3000.gwwhit.materials.hoke;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class HokeSword extends SwordItem {
public HokeSword(ToolMaterial material) {super(material, 5, -0.4089347886705679f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}