package fr.anatom3000.gwwhit.materials.wemhec;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class WemhecBlock extends Block {
public WemhecBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.44884632406108f,4.738354687675475f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}