package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.block.entity.InfectedMassBlockEntity;
import fr.anatom3000.gwwhit.block.entity.RandomisingBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {

    public static final BlockEntityType<?> INFECTED_MASS_BLOCK_ENTITY = BlockEntityType.Builder.create(InfectedMassBlockEntity::new, BlockRegistry.get("infected_mass")).build(null);
    public static final BlockEntityType<?> RANDOMISING_BLOCK_ENTITY = BlockEntityType.Builder.create(RandomisingBlockEntity::new, BlockRegistry.get("randomising_block")).build(null);

    public static void register() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, GuessWhatWillHappenInThisMod.ID("infected_mass"), INFECTED_MASS_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, GuessWhatWillHappenInThisMod.ID("randomising_block"), RANDOMISING_BLOCK_ENTITY);
    }

}
