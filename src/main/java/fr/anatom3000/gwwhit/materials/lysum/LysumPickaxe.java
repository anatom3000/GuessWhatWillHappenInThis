package fr.anatom3000.gwwhit.materials.lysum;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class LysumPickaxe extends PickaxeItem {
public LysumPickaxe(ToolMaterial material) {super(material, 5, -1.5658873752962545f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}