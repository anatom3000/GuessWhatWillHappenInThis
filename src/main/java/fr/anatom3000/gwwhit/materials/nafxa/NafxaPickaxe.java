package fr.anatom3000.gwwhit.materials.nafxa;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class NafxaPickaxe extends PickaxeItem {
    public NafxaPickaxe(ToolMaterial material) {
        super(material, 4, 0.6723322813770126f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}