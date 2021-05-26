package fr.anatom3000.gwwhit.materials.amader;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AmaderPickaxe extends PickaxeItem {
    public AmaderPickaxe(ToolMaterial material) {
        super(material, 4, -1.8969579055334065f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}