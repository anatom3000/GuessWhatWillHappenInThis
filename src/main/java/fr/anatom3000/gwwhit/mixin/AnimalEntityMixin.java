package fr.anatom3000.gwwhit.mixin;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin extends PassiveEntity {

	protected AnimalEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject( method = "breed", at = @At("HEAD"), cancellable = true )
	public void onBreed(ServerWorld world, AnimalEntity other, CallbackInfo ci) {
		if ( ConfigManager.getLoadedConfig().gameplay.mobsUseCondoms ) {
			// AUTHOR: ENDERZOMBI102
			if ( world.random.nextDouble() < 0.2 ) {
				world.spawnEntity(
						new ItemEntity(
								world,
								this.getX(),
								this.getY(),
								this.getZ(),
								new ItemStack( ItemRegistry.get("condom") )
						)
				);
				ci.cancel();
			}
		}
	}
}
