package fr.anatom3000.gwwhit.materials.loded;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LodedBlock extends Block {
public LodedBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.3143613274130503f,2.015023086608885f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0).slipperiness(0.8402559690947797f));}

}