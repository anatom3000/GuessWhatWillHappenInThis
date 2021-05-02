package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.block.InfectedMassBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class BlockRegistry {

    private static final HashMap<String, Block> BLOCKS = new HashMap<String, Block>() {{
        put("infected_mass", new InfectedMassBlock(FabricBlockSettings.of(Material.SOIL, MaterialColor.PURPLE).strength(10, 4f).sounds(BlockSoundGroup.SOUL_SOIL)));
        put("inert_infected_mass", new Block(FabricBlockSettings.of(Material.SOIL, MaterialColor.PURPLE).strength(10, 4f).sounds(BlockSoundGroup.SOUL_SOIL)));
    }};

    public static void register() {
        for (Map.Entry<String, Block> block : BLOCKS.entrySet()) {
            Registry.register(Registry.BLOCK, GuessWhatWillHappenInThisMod.ID(block.getKey()), block.getValue());
        }
    }

    public static Block get(String blockId) {
        return BLOCKS.getOrDefault(blockId, Blocks.AIR);
    }

}
