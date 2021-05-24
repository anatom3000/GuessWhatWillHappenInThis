package fr.anatom3000.gwwhit.materials.zawuf;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class ZawufBlock extends Block {
public ZawufBlock() {super(FabricBlockSettings.of(Material.METAL).strength(3.250817848767256f,3.6778040632377955f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}