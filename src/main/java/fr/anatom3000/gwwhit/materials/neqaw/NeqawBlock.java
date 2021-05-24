package fr.anatom3000.gwwhit.materials.neqaw;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class NeqawBlock extends Block {
public NeqawBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.5969519643649353f,2.1444373929339013f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}