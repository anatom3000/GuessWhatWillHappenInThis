package fr.anatom3000.gwwhit.materials.foqepm;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FoqepmPickaxe extends PickaxeItem {
public FoqepmPickaxe(ToolMaterial material) {super(material, 4, 0.39769619361080655f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}