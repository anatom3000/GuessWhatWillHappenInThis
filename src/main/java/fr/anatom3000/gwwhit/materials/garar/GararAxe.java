package fr.anatom3000.gwwhit.materials.garar;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class GararAxe extends AxeItem {
    public GararAxe(ToolMaterial material) {
        super(material, 2, -0.9251114789600596f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}