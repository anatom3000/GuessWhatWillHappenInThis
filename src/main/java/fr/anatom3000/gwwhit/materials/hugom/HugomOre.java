package fr.anatom3000.gwwhit.materials.hugom;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class HugomOre extends Block {
public HugomOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.831169711630695f,1.1322997320594994f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}