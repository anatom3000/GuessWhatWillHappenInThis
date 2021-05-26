package fr.anatom3000.gwwhit.materials.asymcof;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AsymcofPickaxe extends PickaxeItem {
    public AsymcofPickaxe(ToolMaterial material) {
        super(material, 5, 0.4509556062842024f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}