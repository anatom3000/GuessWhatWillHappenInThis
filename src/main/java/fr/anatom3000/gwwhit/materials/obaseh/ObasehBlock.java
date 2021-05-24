package fr.anatom3000.gwwhit.materials.obaseh;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class ObasehBlock extends Block {
public ObasehBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.9844008373383866f,3.8564149777732926f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}