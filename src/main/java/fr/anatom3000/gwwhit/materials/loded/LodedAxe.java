package fr.anatom3000.gwwhit.materials.loded;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
public class LodedAxe extends AxeItem {
public LodedAxe(ToolMaterial material) {super(material, 5, -0.40164924431041715f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}