package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class WemhecPickaxe extends PickaxeItem {
public WemhecPickaxe(ToolMaterial material) {super(material, 4, -1.3484202080238927f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}