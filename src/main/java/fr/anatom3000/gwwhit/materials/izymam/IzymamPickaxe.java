package fr.anatom3000.gwwhit.materials.izymam;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.PickaxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class IzymamPickaxe extends PickaxeItem {
public IzymamPickaxe(ToolMaterial material) {super(material, 4, -0.9470944963481125f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}