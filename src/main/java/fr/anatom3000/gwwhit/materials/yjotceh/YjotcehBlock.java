package fr.anatom3000.gwwhit.materials.yjotceh;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class YjotcehBlock extends Block {
public YjotcehBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.7466234188625087f,2.0991076153571644f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}