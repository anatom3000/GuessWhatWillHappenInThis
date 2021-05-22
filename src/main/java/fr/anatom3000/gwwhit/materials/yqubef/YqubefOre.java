package fr.anatom3000.gwwhit.materials.yqubef;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class YqubefOre extends Block {
public YqubefOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.2558084941717684f,2.054714714493969f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}