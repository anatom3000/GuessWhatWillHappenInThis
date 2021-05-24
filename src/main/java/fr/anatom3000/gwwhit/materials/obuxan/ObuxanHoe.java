package fr.anatom3000.gwwhit.materials.obuxan;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class ObuxanHoe extends HoeItem {
public ObuxanHoe(ToolMaterial material) {super(material, 6, 0.23240893032410315f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}