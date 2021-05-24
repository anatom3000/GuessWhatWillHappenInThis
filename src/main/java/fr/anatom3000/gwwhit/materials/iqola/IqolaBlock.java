package fr.anatom3000.gwwhit.materials.iqola;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class IqolaBlock extends Block {
public IqolaBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.6576814738711207f,1.6803113267782739f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}