package fr.anatom3000.gwwhit.materials.cojos;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class CojosPickaxe extends PickaxeItem {
    public CojosPickaxe(ToolMaterial material) {
        super(material, 8, -0.68224477920627f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}