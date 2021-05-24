package fr.anatom3000.gwwhit.materials.rydyrp;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class RydyrpOre extends Block {
public RydyrpOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.535047459890229f,3.198590248363163f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}