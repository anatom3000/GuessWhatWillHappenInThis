package fr.anatom3000.gwwhit.materials.izymam;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
public class IzymamShovel extends ShovelItem {
public IzymamShovel(ToolMaterial material) {super(material, 2, 0.7908590644081448f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}