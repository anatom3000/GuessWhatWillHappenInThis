package fr.anatom3000.gwwhit.materials.emussazr;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class EmussazrShovel extends ShovelItem {
public EmussazrShovel(ToolMaterial material) {super(material, 5, -1.05454325526552f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}