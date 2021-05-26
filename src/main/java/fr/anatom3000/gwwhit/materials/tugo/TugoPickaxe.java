package fr.anatom3000.gwwhit.materials.tugo;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class TugoPickaxe extends PickaxeItem {
    public TugoPickaxe(ToolMaterial material) {
        super(material, 2, -0.943841022625223f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}