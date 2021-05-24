package fr.anatom3000.gwwhit.materials.ryqo;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class RyqoBlock extends Block {
public RyqoBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.568845296175102f,4.625908568029239f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}