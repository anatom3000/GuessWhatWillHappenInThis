package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WemhecShovel extends ShovelItem {
public WemhecShovel(ToolMaterial material) {super(material, 3, -0.01761134015427479f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}