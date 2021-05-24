package fr.anatom3000.gwwhit.materials.izymam;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.AxeItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class IzymamAxe extends AxeItem {
public IzymamAxe(ToolMaterial material) {super(material, 1, 0.10192212501255804f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}