package fr.anatom3000.gwwhit.materials.kuqoc;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class KuqocBlock extends Block {
public KuqocBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.00056298568912f,2.83465940238211f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}