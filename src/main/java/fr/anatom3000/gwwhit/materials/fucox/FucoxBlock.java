package fr.anatom3000.gwwhit.materials.fucox;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class FucoxBlock extends Block {
public FucoxBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.058751377033673f,4.809084437011796f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}