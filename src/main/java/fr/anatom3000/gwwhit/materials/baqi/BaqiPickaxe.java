package fr.anatom3000.gwwhit.materials.baqi;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BaqiPickaxe extends PickaxeItem {
    public BaqiPickaxe(ToolMaterial material) {
        super(material, 7, -1.940227109573423f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}