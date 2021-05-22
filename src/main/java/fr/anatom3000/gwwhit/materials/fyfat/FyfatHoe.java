package fr.anatom3000.gwwhit.materials.fyfat;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FyfatHoe extends HoeItem {
public FyfatHoe(ToolMaterial material) {super(material, 3, -1.1517052441047784f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}