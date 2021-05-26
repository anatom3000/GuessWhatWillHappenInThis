package fr.anatom3000.gwwhit.materials.folso;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class FolsoAxe extends AxeItem {
    public FolsoAxe(ToolMaterial material) {
        super(material, 2, 0.024639828192705715f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}