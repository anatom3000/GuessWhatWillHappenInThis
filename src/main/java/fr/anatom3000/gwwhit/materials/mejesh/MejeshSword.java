package fr.anatom3000.gwwhit.materials.mejesh;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class MejeshSword extends SwordItem {
    public MejeshSword(ToolMaterial material) {
        super(material, 14, -0.10123493270614237f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}