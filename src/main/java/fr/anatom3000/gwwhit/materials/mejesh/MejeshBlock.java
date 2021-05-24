package fr.anatom3000.gwwhit.materials.mejesh;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class MejeshBlock extends Block {
public MejeshBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.628913816797731f,4.194409895833226f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}