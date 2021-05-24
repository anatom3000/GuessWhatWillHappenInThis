package fr.anatom3000.gwwhit.materials.exuzi;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class ExuziSword extends SwordItem {
public ExuziSword(ToolMaterial material) {super(material, 6, 0.6758353517135333f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}