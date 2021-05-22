package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AmaderHoe extends HoeItem {
public AmaderHoe(ToolMaterial material) {super(material, 6, 0.863564976087753f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}