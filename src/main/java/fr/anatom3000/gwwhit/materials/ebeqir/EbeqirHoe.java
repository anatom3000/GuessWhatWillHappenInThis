package fr.anatom3000.gwwhit.materials.ebeqir;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class EbeqirHoe extends HoeItem {
public EbeqirHoe(ToolMaterial material) {super(material, 8, -1.2360571369607074f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}