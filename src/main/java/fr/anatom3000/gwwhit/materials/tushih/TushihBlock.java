package fr.anatom3000.gwwhit.materials.tushih;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class TushihBlock extends Block {
public TushihBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.435388534154923f,2.7252979966302475f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}