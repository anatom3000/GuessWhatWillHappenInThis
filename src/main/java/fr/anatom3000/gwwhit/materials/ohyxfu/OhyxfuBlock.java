package fr.anatom3000.gwwhit.materials.ohyxfu;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class OhyxfuBlock extends Block {
public OhyxfuBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.934614329831127f,4.387169677866746f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}