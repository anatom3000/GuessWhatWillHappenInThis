package fr.anatom3000.gwwhit.materials.botud;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class BotudAxe extends AxeItem {
public BotudAxe(ToolMaterial material) {super(material, 8, -1.7202124468026563f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}