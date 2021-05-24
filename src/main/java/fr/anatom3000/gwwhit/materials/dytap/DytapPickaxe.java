package fr.anatom3000.gwwhit.materials.dytap;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class DytapPickaxe extends PickaxeItem {
public DytapPickaxe(ToolMaterial material) {super(material, 7, 0.9869507452804485f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}