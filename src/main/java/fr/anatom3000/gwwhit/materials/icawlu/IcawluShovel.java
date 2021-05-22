package fr.anatom3000.gwwhit.materials.icawlu;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class IcawluShovel extends ShovelItem {
public IcawluShovel(ToolMaterial material) {super(material, 6, -0.41425177885878295f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}