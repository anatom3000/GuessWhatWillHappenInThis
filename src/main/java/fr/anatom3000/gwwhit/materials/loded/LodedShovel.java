package fr.anatom3000.gwwhit.materials.loded;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
public class LodedShovel extends ShovelItem {
public LodedShovel(ToolMaterial material) {super(material, 8, -0.7970754359495023f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}