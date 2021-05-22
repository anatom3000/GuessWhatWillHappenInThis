package fr.anatom3000.gwwhit.materials.renu;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class RenuShovel extends ShovelItem {
public RenuShovel(ToolMaterial material) {super(material, 3, -0.6184623676121657f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}