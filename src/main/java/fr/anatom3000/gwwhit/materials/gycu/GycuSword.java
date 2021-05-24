package fr.anatom3000.gwwhit.materials.gycu;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class GycuSword extends SwordItem {
public GycuSword(ToolMaterial material) {super(material, 16, 0.08072492933047026f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}