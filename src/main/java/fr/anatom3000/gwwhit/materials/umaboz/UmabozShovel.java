package fr.anatom3000.gwwhit.materials.umaboz;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UmabozShovel extends ShovelItem {
public UmabozShovel(ToolMaterial material) {super(material, 3, 0.31669858242119464f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}