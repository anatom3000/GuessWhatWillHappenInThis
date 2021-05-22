package fr.anatom3000.gwwhit.materials.lisluq;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LisluqOre extends Block {
public LisluqOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.86715504264314f,4.521702004858694f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}