package fr.anatom3000.gwwhit.materials.ywosduk;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class YwosdukBlock extends Block {
public YwosdukBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.5623478770931882f,2.664279379455539f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.7411951852765625f));}

}