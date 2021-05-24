package fr.anatom3000.gwwhit.materials.uhyqol;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class UhyqolOre extends Block {
public UhyqolOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.753951702568491f,2.9066074406262907f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}