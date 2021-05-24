package fr.anatom3000.gwwhit.materials.mudatb;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class MudatbOre extends Block {
public MudatbOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.6302105090144665f,4.963595127333379f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}