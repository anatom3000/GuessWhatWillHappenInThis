package fr.anatom3000.gwwhit.materials.lezdor;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LezdorBlock extends Block {
public LezdorBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.855320847752626f,3.466843311687021f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}