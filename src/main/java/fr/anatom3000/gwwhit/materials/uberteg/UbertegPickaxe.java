package fr.anatom3000.gwwhit.materials.uberteg;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UbertegPickaxe extends PickaxeItem {
public UbertegPickaxe(ToolMaterial material) {super(material, 6, -1.4793292599600765f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}