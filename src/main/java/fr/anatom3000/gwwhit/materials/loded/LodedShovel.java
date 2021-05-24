package fr.anatom3000.gwwhit.materials.loded;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class LodedShovel extends ShovelItem {
public LodedShovel(ToolMaterial material) {super(material, 8, -0.7970754359495023f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}