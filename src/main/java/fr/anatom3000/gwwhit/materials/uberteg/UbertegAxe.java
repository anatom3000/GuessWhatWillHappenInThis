package fr.anatom3000.gwwhit.materials.uberteg;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UbertegAxe extends AxeItem {
public UbertegAxe(ToolMaterial material) {super(material, 6, 0.1060000469353315f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}