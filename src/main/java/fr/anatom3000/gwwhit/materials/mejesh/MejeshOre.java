package fr.anatom3000.gwwhit.materials.mejesh;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class MejeshOre extends Block {
public MejeshOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.8399171529213323f,1.8220717196783727f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}