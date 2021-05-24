package fr.anatom3000.gwwhit.materials.dytap;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class DytapShovel extends ShovelItem {
public DytapShovel(ToolMaterial material) {super(material, 1, -0.8263533584014666f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}