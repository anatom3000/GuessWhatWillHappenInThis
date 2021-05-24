package fr.anatom3000.gwwhit.materials.ebeqir;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class EbeqirSword extends SwordItem {
public EbeqirSword(ToolMaterial material) {super(material, 13, -1.4867967805379791f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}