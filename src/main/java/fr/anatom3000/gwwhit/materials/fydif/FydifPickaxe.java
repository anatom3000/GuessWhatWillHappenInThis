package fr.anatom3000.gwwhit.materials.fydif;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class FydifPickaxe extends PickaxeItem {
    public FydifPickaxe(ToolMaterial material) {
        super(material, 7, 0.6779089475725031f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}