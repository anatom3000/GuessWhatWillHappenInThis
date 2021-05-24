package fr.anatom3000.gwwhit.materials.asymcof;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AsymcofHoe extends HoeItem {
public AsymcofHoe(ToolMaterial material) {super(material, 7, -1.5223151764717269f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}