package fr.anatom3000.gwwhit.materials.kuzidb;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class KuzidbSword extends SwordItem {
public KuzidbSword(ToolMaterial material) {super(material, 5, -1.1437348380314147f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}