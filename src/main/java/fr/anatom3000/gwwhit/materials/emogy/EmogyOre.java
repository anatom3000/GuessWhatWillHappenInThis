package fr.anatom3000.gwwhit.materials.emogy;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class EmogyOre extends Block {
public EmogyOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.5971413820150935f,3.3921055132188536f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}