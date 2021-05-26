package fr.anatom3000.gwwhit.materials.fyfat;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class FyfatPickaxe extends PickaxeItem {
    public FyfatPickaxe(ToolMaterial material) {
        super(material, 7, -0.22198141343441802f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}