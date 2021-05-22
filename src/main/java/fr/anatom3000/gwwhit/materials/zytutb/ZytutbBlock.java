package fr.anatom3000.gwwhit.materials.zytutb;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
public class ZytutbBlock extends Block {
public ZytutbBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.781450763135314f,4.356391353769428f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

public int getStrongRedstonePower(BlockState state, BlockPos pos, Direction direction) {
return 10;
}
}