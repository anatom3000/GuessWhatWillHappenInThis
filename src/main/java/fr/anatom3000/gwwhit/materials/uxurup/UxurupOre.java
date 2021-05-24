package fr.anatom3000.gwwhit.materials.uxurup;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class UxurupOre extends Block {
public UxurupOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.5181291584583785f,4.489720722059051f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}