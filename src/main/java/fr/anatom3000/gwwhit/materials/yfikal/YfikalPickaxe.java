package fr.anatom3000.gwwhit.materials.yfikal;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class YfikalPickaxe extends PickaxeItem {
    public YfikalPickaxe(ToolMaterial material) {
        super(material, 7, 0.1258374085276912f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}