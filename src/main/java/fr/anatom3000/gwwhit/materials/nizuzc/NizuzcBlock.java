package fr.anatom3000.gwwhit.materials.nizuzc;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class NizuzcBlock extends Block {
public NizuzcBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.8451189030996193f,2.7598381979559874f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}