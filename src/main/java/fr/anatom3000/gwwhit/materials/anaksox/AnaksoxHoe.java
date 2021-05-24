package fr.anatom3000.gwwhit.materials.anaksox;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AnaksoxHoe extends HoeItem {
public AnaksoxHoe(ToolMaterial material) {super(material, 5, 0.5943235613726227f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}