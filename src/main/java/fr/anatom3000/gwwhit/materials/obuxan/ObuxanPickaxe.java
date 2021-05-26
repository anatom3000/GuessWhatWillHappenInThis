package fr.anatom3000.gwwhit.materials.obuxan;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ObuxanPickaxe extends PickaxeItem {
    public ObuxanPickaxe(ToolMaterial material) {
        super(material, 7, 0.9393416531397034f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}