package fr.anatom3000.gwwhit.materials.otakag;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class OtakagOre extends Block {
public OtakagOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.556025044681982f,4.327806248506748f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}