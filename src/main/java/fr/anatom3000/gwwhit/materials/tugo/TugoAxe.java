package fr.anatom3000.gwwhit.materials.tugo;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class TugoAxe extends AxeItem {
public TugoAxe(ToolMaterial material) {super(material, 2, -1.8207597990915492f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}