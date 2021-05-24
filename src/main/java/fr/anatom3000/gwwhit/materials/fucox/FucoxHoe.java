package fr.anatom3000.gwwhit.materials.fucox;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FucoxHoe extends HoeItem {
public FucoxHoe(ToolMaterial material) {super(material, 4, -1.7770091613613315f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}