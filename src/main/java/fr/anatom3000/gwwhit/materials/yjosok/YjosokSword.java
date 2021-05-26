package fr.anatom3000.gwwhit.materials.yjosok;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class YjosokSword extends SwordItem {
    public YjosokSword(ToolMaterial material) {
        super(material, 3, 0.7230654525452616f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}