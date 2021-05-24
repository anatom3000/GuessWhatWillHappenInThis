package fr.anatom3000.gwwhit.materials.garar;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class GararHoe extends HoeItem {
public GararHoe(ToolMaterial material) {super(material, 2, -1.9305911896573962f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}