package fr.anatom3000.gwwhit.materials.fyfat;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FyfatShovel extends ShovelItem {
public FyfatShovel(ToolMaterial material) {super(material, 5, 0.20907177640359553f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}