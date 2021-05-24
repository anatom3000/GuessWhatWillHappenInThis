package fr.anatom3000.gwwhit.materials.folso;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class FolsoAxe extends AxeItem {
public FolsoAxe(ToolMaterial material) {super(material, 2, 0.024639828192705715f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}