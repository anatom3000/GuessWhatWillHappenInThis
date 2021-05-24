package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AmaderShovel extends ShovelItem {
public AmaderShovel(ToolMaterial material) {super(material, 1, -1.9809119478199726f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}