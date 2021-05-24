package fr.anatom3000.gwwhit.materials.peqy;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class PeqySword extends SwordItem {
public PeqySword(ToolMaterial material) {super(material, 5, -0.07874151318768918f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}