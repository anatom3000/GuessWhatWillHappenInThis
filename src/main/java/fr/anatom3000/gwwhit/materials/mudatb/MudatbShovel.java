package fr.anatom3000.gwwhit.materials.mudatb;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class MudatbShovel extends ShovelItem {
public MudatbShovel(ToolMaterial material) {super(material, 2, 0.7740866846823934f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}