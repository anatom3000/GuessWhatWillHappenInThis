package fr.anatom3000.gwwhit.materials.hugom;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class HugomSword extends SwordItem {
public HugomSword(ToolMaterial material) {super(material, 4, 0.19671859417713988f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}