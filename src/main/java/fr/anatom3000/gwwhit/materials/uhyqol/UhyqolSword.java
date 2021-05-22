package fr.anatom3000.gwwhit.materials.uhyqol;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class UhyqolSword extends SwordItem {
public UhyqolSword(ToolMaterial material) {super(material, 10, -1.3232972471498754f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}