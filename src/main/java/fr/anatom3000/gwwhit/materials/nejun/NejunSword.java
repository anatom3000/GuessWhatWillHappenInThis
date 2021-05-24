package fr.anatom3000.gwwhit.materials.nejun;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class NejunSword extends SwordItem {
public NejunSword(ToolMaterial material) {super(material, 15, -0.9191248711145099f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}