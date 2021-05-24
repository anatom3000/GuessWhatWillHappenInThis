package fr.anatom3000.gwwhit.materials.ecywygs;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class EcywygsShovel extends ShovelItem {
public EcywygsShovel(ToolMaterial material) {super(material, 4, -1.6553549939485173f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}