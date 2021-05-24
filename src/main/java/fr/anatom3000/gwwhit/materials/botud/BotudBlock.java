package fr.anatom3000.gwwhit.materials.botud;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class BotudBlock extends Block {
public BotudBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.895546018727078f,1.647412322453087f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}