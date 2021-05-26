package fr.anatom3000.gwwhit.materials.folso;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class FolsoPickaxe extends PickaxeItem {
    public FolsoPickaxe(ToolMaterial material) {
        super(material, 4, 0.7148737744083944f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}