package fr.anatom3000.gwwhit.materials.garar;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
public class GararShovel extends ShovelItem {
public GararShovel(ToolMaterial material) {super(material, 3, -0.08887667702317037f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}