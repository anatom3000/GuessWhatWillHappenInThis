package fr.anatom3000.gwwhit.materials.cojos;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class CojosSword extends SwordItem {
public CojosSword(ToolMaterial material) {super(material, 5, 0.15799641380855f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}