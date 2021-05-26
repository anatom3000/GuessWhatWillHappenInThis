package fr.anatom3000.gwwhit.materials.anaksox;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
public class AnaksoxHoe extends HoeItem {
public AnaksoxHoe(ToolMaterial material) {super(material, 5, 0.5943235613726227f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}