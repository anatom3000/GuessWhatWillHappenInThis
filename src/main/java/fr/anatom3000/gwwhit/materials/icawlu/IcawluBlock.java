package fr.anatom3000.gwwhit.materials.icawlu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class IcawluBlock extends Block {
public IcawluBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.857869929715329f,4.754838937487107f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1).slipperiness(0.9732860557488623f));}

}