package fr.anatom3000.gwwhit.materials.mudatb;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
public class MudatbAxe extends AxeItem {
public MudatbAxe(ToolMaterial material) {super(material, 4, 0.09621812805394192f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}