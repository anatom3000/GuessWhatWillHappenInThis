package fr.anatom3000.gwwhit.materials.renu;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class RenuHoe extends HoeItem {
public RenuHoe(ToolMaterial material) {super(material, 5, -1.6529362869997604f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}