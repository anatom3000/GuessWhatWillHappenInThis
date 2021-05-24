package fr.anatom3000.gwwhit.materials.kigys;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class KigysShovel extends ShovelItem {
public KigysShovel(ToolMaterial material) {super(material, 5, -1.5324342172745213f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}