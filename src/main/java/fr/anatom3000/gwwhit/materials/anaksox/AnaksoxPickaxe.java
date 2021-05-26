package fr.anatom3000.gwwhit.materials.anaksox;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AnaksoxPickaxe extends PickaxeItem {
    public AnaksoxPickaxe(ToolMaterial material) {
        super(material, 4, -0.9805750760383036f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}