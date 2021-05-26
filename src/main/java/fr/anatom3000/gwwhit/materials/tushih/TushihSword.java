package fr.anatom3000.gwwhit.materials.tushih;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class TushihSword extends SwordItem {
    public TushihSword(ToolMaterial material) {
        super(material, 8, -0.18727402726268672f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}