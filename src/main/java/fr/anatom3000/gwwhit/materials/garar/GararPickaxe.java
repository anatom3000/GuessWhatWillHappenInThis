package fr.anatom3000.gwwhit.materials.garar;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class GararPickaxe extends PickaxeItem {
public GararPickaxe(ToolMaterial material) {super(material, 7, -1.9331763836315576f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}