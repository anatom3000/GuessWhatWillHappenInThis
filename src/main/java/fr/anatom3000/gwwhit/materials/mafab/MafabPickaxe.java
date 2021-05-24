package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class MafabPickaxe extends PickaxeItem {
public MafabPickaxe(ToolMaterial material) {super(material, 2, -1.1614468253030497f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}