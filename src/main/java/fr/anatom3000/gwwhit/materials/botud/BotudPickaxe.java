package fr.anatom3000.gwwhit.materials.botud;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class BotudPickaxe extends PickaxeItem {
public BotudPickaxe(ToolMaterial material) {super(material, 3, -1.6514860169309467f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}