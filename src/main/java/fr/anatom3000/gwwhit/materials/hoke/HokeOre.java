package fr.anatom3000.gwwhit.materials.hoke;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class HokeOre extends Block {
public HokeOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.327095668626132f,2.7601037906941257f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.7664829949827581f));}

}