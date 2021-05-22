package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class MafabAxe extends AxeItem {
public MafabAxe(ToolMaterial material) {super(material, 5, -1.540897981555049f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}