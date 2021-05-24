package fr.anatom3000.gwwhit.materials.nejun;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class NejunBlock extends Block {
public NejunBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.1418723658311514f,3.2793034861422825f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}