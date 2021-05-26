package fr.anatom3000.gwwhit.materials.anaksox;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class AnaksoxShovel extends ShovelItem {
    public AnaksoxShovel(ToolMaterial material) {
        super(material, 3, 0.7793923281573581f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}