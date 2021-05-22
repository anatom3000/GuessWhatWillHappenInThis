package fr.anatom3000.gwwhit.materials.anaksox;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class AnaksoxBlock extends Block {
public AnaksoxBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.6814080560344435f,4.512405691425073f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}