package fr.anatom3000.gwwhit.materials.umaboz;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UmabozHoe extends HoeItem {
public UmabozHoe(ToolMaterial material) {super(material, 7, -1.004125345985428f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}