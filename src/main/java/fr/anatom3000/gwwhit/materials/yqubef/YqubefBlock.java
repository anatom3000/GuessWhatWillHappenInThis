package fr.anatom3000.gwwhit.materials.yqubef;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class YqubefBlock extends Block {
public YqubefBlock() {super(FabricBlockSettings.of(Material.METAL).strength(4.311223746939808f,4.990162821721631f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}