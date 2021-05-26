package fr.anatom3000.gwwhit.materials.tugo;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
public class TugoAxe extends AxeItem {
public TugoAxe(ToolMaterial material) {super(material, 2, -1.8207597990915492f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}