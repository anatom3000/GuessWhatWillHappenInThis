package fr.anatom3000.gwwhit.materials.mudatb;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class MudatbPickaxe extends PickaxeItem {
public MudatbPickaxe(ToolMaterial material) {super(material, 7, -0.9726306684385531f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}