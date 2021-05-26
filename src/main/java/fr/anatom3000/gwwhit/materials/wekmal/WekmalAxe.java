package fr.anatom3000.gwwhit.materials.wekmal;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
public class WekmalAxe extends AxeItem {
public WekmalAxe(ToolMaterial material) {super(material, 1, -1.5725439933770349f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}