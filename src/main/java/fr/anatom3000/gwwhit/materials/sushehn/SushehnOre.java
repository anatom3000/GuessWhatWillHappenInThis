package fr.anatom3000.gwwhit.materials.sushehn;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class SushehnOre extends Block {
public SushehnOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.042314900961967f,4.535764279559878f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}