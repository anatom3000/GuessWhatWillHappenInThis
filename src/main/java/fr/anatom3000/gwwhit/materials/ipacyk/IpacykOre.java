package fr.anatom3000.gwwhit.materials.ipacyk;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class IpacykOre extends Block {
public IpacykOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.382447111002906f,1.7733044710387258f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}