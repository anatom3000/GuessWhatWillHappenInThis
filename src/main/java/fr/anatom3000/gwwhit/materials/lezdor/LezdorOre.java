package fr.anatom3000.gwwhit.materials.lezdor;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LezdorOre extends Block {
public LezdorOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.472960557070697f,1.422640976883577f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).luminance(2));}

}