package fr.anatom3000.gwwhit.materials.loded;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LodedOre extends Block {
public LodedOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.8145814230349977f,1.8744747390428116f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}