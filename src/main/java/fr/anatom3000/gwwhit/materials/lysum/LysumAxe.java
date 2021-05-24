package fr.anatom3000.gwwhit.materials.lysum;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class LysumAxe extends AxeItem {
public LysumAxe(ToolMaterial material) {super(material, 4, 0.61277378345849f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}