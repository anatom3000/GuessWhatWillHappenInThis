package fr.anatom3000.gwwhit.materials.asymcof;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class AsymcofBlock extends Block {
public AsymcofBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.2041225327542704f,3.6898874468318734f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}