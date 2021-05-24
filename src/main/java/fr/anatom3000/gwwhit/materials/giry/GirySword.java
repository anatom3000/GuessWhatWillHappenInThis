package fr.anatom3000.gwwhit.materials.giry;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class GirySword extends SwordItem {
public GirySword(ToolMaterial material) {super(material, 5, 0.23957579788924133f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}