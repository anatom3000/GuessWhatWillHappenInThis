package fr.anatom3000.gwwhit.materials.garar;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class GararOre extends Block {
public GararOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.3234877943047625f,3.8066518989879503f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}