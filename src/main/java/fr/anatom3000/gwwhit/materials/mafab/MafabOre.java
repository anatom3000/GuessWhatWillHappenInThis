package fr.anatom3000.gwwhit.materials.mafab;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class MafabOre extends Block {
public MafabOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.2086324757403393f,1.127308210678227f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}