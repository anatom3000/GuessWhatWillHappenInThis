package fr.anatom3000.gwwhit.materials.fydif;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
public class FydifAxe extends AxeItem {
public FydifAxe(ToolMaterial material) {super(material, 2, -1.1886662892843116f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}