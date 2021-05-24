package fr.anatom3000.gwwhit.materials.kuzidb;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
public class KuzidbOre extends Block {
public KuzidbOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.2006274717750305f,3.9620378260303157f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

public int getStrongRedstonePower(BlockState state, BlockPos pos, Direction direction) {
return 5;
}
}