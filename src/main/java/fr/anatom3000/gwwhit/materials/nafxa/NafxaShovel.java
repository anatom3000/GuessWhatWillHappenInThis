package fr.anatom3000.gwwhit.materials.nafxa;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class NafxaShovel extends ShovelItem {
public NafxaShovel(ToolMaterial material) {super(material, 5, 0.049246907703259124f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}