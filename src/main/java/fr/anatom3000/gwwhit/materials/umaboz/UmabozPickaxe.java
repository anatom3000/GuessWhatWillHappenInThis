package fr.anatom3000.gwwhit.materials.umaboz;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class UmabozPickaxe extends PickaxeItem {
    public UmabozPickaxe(ToolMaterial material) {
        super(material, 1, 0.5402790381875862f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}