package fr.anatom3000.gwwhit.materials.lysum;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
public class LysumAxe extends AxeItem {
public LysumAxe(ToolMaterial material) {super(material, 4, 0.61277378345849f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}