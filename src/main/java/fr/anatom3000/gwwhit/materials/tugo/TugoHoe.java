package fr.anatom3000.gwwhit.materials.tugo;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class TugoHoe extends HoeItem {
public TugoHoe(ToolMaterial material) {super(material, 1, -1.9742980739009024f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}