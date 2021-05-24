package fr.anatom3000.gwwhit.materials.neqaw;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class NeqawSword extends SwordItem {
public NeqawSword(ToolMaterial material) {super(material, 4, -0.40683130213486285f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}