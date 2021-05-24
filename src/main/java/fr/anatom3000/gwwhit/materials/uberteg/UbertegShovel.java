package fr.anatom3000.gwwhit.materials.uberteg;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UbertegShovel extends ShovelItem {
public UbertegShovel(ToolMaterial material) {super(material, 3, -1.1915052158418922f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}