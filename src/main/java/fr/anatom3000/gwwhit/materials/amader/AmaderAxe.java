package fr.anatom3000.gwwhit.materials.amader;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AmaderAxe extends AxeItem {
public AmaderAxe(ToolMaterial material) {super(material, 5, 0.8167527922661645f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}