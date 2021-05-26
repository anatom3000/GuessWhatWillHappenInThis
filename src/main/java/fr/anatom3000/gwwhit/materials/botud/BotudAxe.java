package fr.anatom3000.gwwhit.materials.botud;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class BotudAxe extends AxeItem {
    public BotudAxe(ToolMaterial material) {
        super(material, 8, -1.7202124468026563f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));
    }

}