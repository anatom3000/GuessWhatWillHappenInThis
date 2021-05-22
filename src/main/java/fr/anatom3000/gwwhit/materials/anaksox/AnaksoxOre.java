package fr.anatom3000.gwwhit.materials.anaksox;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class AnaksoxOre extends Block {
public AnaksoxOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.2356204987936117f,3.3451029887423895f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}