package fr.anatom3000.gwwhit.materials.neqaw;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class NeqawOre extends Block {
public NeqawOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.9556859209403212f,1.4735036822625345f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}