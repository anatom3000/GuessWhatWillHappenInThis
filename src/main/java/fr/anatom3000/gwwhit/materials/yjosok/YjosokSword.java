package fr.anatom3000.gwwhit.materials.yjosok;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class YjosokSword extends SwordItem {
public YjosokSword(ToolMaterial material) {super(material, 3, 0.7230654525452616f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}