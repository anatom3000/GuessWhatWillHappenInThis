package fr.anatom3000.gwwhit.materials.fucox;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FucoxPickaxe extends PickaxeItem {
public FucoxPickaxe(ToolMaterial material) {super(material, 2, -0.3030924507436805f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}