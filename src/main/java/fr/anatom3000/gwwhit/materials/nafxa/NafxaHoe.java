package fr.anatom3000.gwwhit.materials.nafxa;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
public class NafxaHoe extends HoeItem {
public NafxaHoe(ToolMaterial material) {super(material, 1, 0.2537507565330581f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}