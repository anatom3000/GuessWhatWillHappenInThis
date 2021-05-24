package fr.anatom3000.gwwhit.materials.zytutb;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class ZytutbOre extends Block {
public ZytutbOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.7796033242652385f,4.253294922855739f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}