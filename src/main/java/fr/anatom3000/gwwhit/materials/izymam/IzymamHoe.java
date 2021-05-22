package fr.anatom3000.gwwhit.materials.izymam;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class IzymamHoe extends HoeItem {
public IzymamHoe(ToolMaterial material) {super(material, 7, -1.2649152061457936f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}