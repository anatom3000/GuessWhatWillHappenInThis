package fr.anatom3000.gwwhit.materials.loded;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
public class LodedPickaxe extends PickaxeItem {
public LodedPickaxe(ToolMaterial material) {super(material, 3, -0.6847327410794972f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}