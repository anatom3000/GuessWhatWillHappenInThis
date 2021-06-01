package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import fr.anatom3000.gwwhit.block.entity.InfectedMassBlockEntity;
import fr.anatom3000.gwwhit.block.entity.RandomisingBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {

    public static final BlockEntityType<InfectedMassBlockEntity> INFECTED_MASS_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(InfectedMassBlockEntity::new, BlockRegistry.get("infected_mass")).build(null);
    public static final BlockEntityType<RandomisingBlockEntity> RANDOMISING_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(RandomisingBlockEntity::new, BlockRegistry.get("randomising_block")).build(null);

    public static void register() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, GuessWhatWillHappenInThisMod.getId("infected_mass"), INFECTED_MASS_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, GuessWhatWillHappenInThisMod.getId("randomising_block"), RANDOMISING_BLOCK_ENTITY);
    }
}
