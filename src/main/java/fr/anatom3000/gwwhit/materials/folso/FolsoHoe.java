package fr.anatom3000.gwwhit.materials.folso;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FolsoHoe extends HoeItem {
public FolsoHoe(ToolMaterial material) {super(material, 5, 0.8152061597318953f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}