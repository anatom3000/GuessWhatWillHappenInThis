package fr.anatom3000.gwwhit.materials.iqecoln;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class IqecolnBlock extends Block {
public IqecolnBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.088000516234878f,3.681516034707085f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}