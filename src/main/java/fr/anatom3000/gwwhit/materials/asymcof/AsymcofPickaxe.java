package fr.anatom3000.gwwhit.materials.asymcof;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AsymcofPickaxe extends PickaxeItem {
public AsymcofPickaxe(ToolMaterial material) {super(material, 5, 0.4509556062842024f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}