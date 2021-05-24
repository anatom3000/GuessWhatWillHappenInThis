package fr.anatom3000.gwwhit.materials.ikaqajc;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class IkaqajcBlock extends Block {
public IkaqajcBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.31886082293468f,1.407981946078615f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}