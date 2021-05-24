package fr.anatom3000.gwwhit.materials.zawuf;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class ZawufShovel extends ShovelItem {
public ZawufShovel(ToolMaterial material) {super(material, 3, 0.7553020598402027f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}