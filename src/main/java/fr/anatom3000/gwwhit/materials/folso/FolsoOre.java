package fr.anatom3000.gwwhit.materials.folso;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class FolsoOre extends Block {
public FolsoOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.9096448850323977f,3.3389590472190553f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}