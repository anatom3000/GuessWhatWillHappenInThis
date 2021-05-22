package fr.anatom3000.gwwhit.materials.ebeqir;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class EbeqirPickaxe extends PickaxeItem {
public EbeqirPickaxe(ToolMaterial material) {super(material, 4, 0.16124240401029422f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}