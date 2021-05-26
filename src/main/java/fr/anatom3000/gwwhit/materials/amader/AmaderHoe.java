package fr.anatom3000.gwwhit.materials.amader;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
public class AmaderHoe extends HoeItem {
public AmaderHoe(ToolMaterial material) {super(material, 6, 0.863564976087753f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}