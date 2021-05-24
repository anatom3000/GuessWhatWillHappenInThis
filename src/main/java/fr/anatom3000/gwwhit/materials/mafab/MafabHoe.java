package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class MafabHoe extends HoeItem {
public MafabHoe(ToolMaterial material) {super(material, 3, 0.4672390740704383f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}