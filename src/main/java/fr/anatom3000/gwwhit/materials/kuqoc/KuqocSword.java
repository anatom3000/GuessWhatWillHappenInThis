package fr.anatom3000.gwwhit.materials.kuqoc;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class KuqocSword extends SwordItem {
public KuqocSword(ToolMaterial material) {super(material, 6, -1.9067271658940577f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}