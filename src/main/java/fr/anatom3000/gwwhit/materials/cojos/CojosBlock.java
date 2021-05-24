package fr.anatom3000.gwwhit.materials.cojos;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class CojosBlock extends Block {
public CojosBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.9424443425925553f,3.118955856497523f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}