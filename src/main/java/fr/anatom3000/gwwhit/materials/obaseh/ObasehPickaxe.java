package fr.anatom3000.gwwhit.materials.obaseh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class ObasehPickaxe extends PickaxeItem {
    public ObasehPickaxe(ToolMaterial material) {
        super(material, 3, 0.4869573992734245f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}