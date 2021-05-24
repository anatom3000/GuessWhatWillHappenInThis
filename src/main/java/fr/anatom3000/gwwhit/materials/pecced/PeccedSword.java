package fr.anatom3000.gwwhit.materials.pecced;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;
import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
public class PeccedSword extends SwordItem {
public PeccedSword(ToolMaterial material) {super(material, 10, 0.06940614985490656f, new FabricItemSettings().group(CustomItemGroups.GWWHITGroup));}

}