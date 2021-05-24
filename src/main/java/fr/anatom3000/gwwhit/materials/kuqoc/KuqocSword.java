package fr.anatom3000.gwwhit.materials.kuqoc;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class KuqocSword extends SwordItem {
public KuqocSword(ToolMaterial material) {super(material, 6, -1.9067271658940577f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}