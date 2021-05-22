package fr.anatom3000.gwwhit.materials.ecywygs;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class EcywygsOre extends Block {
public EcywygsOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.646690681816971f,1.4386801129848248f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}