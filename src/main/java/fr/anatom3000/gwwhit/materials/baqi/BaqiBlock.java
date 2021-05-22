package fr.anatom3000.gwwhit.materials.baqi;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class BaqiBlock extends Block {
public BaqiBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.0996065524420806f,2.098160719689327f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}