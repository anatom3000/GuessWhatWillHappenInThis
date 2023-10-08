package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.block.entity.InfectedMassBlockEntity;
import fr.anatom3000.gwwhit.block.entity.RandomisingBlockEntity;
import fr.anatom3000.gwwhit.entity.projectile.SentientArrow;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {

    public static final EntityType<SentientArrow> SENTIENT_ARROW_ENTITY = FabricEntityTypeBuilder.<SentientArrow>create(SpawnGroup.MISC, SentientArrow::new)
    		.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
    		.trackRangeChunks(4)
    		.trackedUpdateRate(20)
    		.fireImmune()
    		.disableSummon()
    		.disableSaving()
    		.build();

    public static void register() {
        Registry.register(Registry.ENTITY_TYPE, GWWHIT.getId("aimbot_arrow"), SENTIENT_ARROW_ENTITY);
    }
}
