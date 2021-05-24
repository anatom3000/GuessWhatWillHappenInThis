package fr.anatom3000.gwwhit.materials.emilamd;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class EmilamdBlock extends Block {
public EmilamdBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.6159729501878695f,4.114099399066217f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}