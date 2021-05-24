package fr.anatom3000.gwwhit.materials.uwalusq;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UwalusqShovel extends ShovelItem {
public UwalusqShovel(ToolMaterial material) {super(material, 2, 0.7020086343129744f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}