package fr.anatom3000.gwwhit.materials.tugo;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class TugoShovel extends ShovelItem {
public TugoShovel(ToolMaterial material) {super(material, 2, 0.15919833951809137f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}