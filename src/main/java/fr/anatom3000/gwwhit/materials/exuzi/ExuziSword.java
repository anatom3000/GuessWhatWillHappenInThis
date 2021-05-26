package fr.anatom3000.gwwhit.materials.exuzi;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class ExuziSword extends SwordItem {
public ExuziSword(ToolMaterial material) {super(material, 6, 0.6758353517135333f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}