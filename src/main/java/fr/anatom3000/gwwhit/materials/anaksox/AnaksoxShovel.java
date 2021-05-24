package fr.anatom3000.gwwhit.materials.anaksox;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ShovelItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class AnaksoxShovel extends ShovelItem {
public AnaksoxShovel(ToolMaterial material) {super(material, 3, 0.7793923281573581f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}