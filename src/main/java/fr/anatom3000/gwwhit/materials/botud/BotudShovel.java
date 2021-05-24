package fr.anatom3000.gwwhit.materials.botud;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class BotudShovel extends ShovelItem {
public BotudShovel(ToolMaterial material) {super(material, 5, -1.1470182854166726f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}