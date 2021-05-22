package fr.anatom3000.gwwhit.materials.senuz;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class SenuzBlock extends Block {
public SenuzBlock() {super(FabricBlockSettings.of(Material.METAL).strength(2.3259587871313485f,4.823242085775082f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}