package fr.anatom3000.gwwhit.materials.obuxan;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
public class ObuxanShovel extends ShovelItem {
public ObuxanShovel(ToolMaterial material) {super(material, 4, 0.8451139381768658f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}