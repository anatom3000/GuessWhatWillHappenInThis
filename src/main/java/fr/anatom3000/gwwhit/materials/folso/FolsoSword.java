package fr.anatom3000.gwwhit.materials.folso;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
public class FolsoSword extends SwordItem {
public FolsoSword(ToolMaterial material) {super(material, 5, -0.22022349261876784f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}