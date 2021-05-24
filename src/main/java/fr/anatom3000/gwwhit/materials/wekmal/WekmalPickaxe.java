package fr.anatom3000.gwwhit.materials.wekmal;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WekmalPickaxe extends PickaxeItem {
public WekmalPickaxe(ToolMaterial material) {super(material, 3, -0.6632676561591178f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}