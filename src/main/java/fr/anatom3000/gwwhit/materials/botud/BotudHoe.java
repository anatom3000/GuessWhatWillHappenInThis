package fr.anatom3000.gwwhit.materials.botud;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.HoeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class BotudHoe extends HoeItem {
public BotudHoe(ToolMaterial material) {super(material, 7, 0.5169554603157201f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}