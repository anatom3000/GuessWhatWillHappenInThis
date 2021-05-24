package fr.anatom3000.gwwhit.materials.dytap;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class DytapAxe extends AxeItem {
public DytapAxe(ToolMaterial material) {super(material, 2, -1.3968333463588594f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}