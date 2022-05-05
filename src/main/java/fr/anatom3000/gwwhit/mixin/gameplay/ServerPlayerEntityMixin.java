package fr.anatom3000.gwwhit.mixin.gameplay;

import fr.anatom3000.gwwhit.registry.ItemRegistry;
import fr.anatom3000.gwwhit.util.PancakeDamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {

    @Shadow
    public ServerPlayNetworkHandler networkHandler;

    private ServerPlayerEntityMixin() {
        //noinspection ConstantConditions
        super(null, null, 0, null);
    }

    @Inject(
        method = "attack",
        at = @At("HEAD"),
        cancellable = true
    )
    public void onAttack( Entity target, CallbackInfo info ) {
        if ( this.getStackInHand(Hand.MAIN_HAND).isOf( ItemRegistry.get("pancakes") ) ) {
            if ( target instanceof PlayerEntity playerEntity ) {
                playerEntity.damage( new PancakeDamageSource( this ), 5 );
            } else if ( target instanceof LivingEntity livingEntity ) {
                livingEntity.heal(5);
                info.cancel();
                this.networkHandler.connection.send(
                    new ParticleS2CPacket(
                        ParticleTypes.HEART,
                        false,
                        livingEntity.getX(),
                        livingEntity.getY() + livingEntity.getStandingEyeHeight(),
                        livingEntity.getZ(),
                        0,
                        1,
                        0,
                        1,
                        2
                    )
                );
            }
        }
    }
}
