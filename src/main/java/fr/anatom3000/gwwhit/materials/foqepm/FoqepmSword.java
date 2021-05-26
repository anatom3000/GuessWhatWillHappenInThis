package fr.anatom3000.gwwhit.materials.foqepm;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class FoqepmSword extends SwordItem {
    public FoqepmSword(ToolMaterial material) {
        super(material, 14, -0.7489696213859811f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}