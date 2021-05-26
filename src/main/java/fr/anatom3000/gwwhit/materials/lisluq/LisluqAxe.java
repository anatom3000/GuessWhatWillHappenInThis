package fr.anatom3000.gwwhit.materials.lisluq;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class LisluqAxe extends AxeItem {
    public LisluqAxe(ToolMaterial material) {
        super(material, 1, -0.39429166410801475f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}