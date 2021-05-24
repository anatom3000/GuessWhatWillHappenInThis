package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class MafabShovel extends ShovelItem {
public MafabShovel(ToolMaterial material) {super(material, 7, -1.3850880914421242f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}