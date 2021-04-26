package fr.anatom3000.gwwhit.mixin;

import com.google.common.collect.BiMap;
import com.mojang.serialization.Codec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = SimpleRegistry.class, priority = 500)
public abstract class SimpleRegistryMixin<T> {
    @ModifyVariable(method = "set(ILnet/minecraft/util/registry/RegistryKey;Ljava/lang/Object;Lcom/mojang/serialization/Lifecycle;Z)Ljava/lang/Object;", at = @At("HEAD"), ordinal = 0)
    private boolean injected(boolean y) {
        return false;
    }

    @Shadow
    @Nullable
    public abstract T getRandom(Random random);

    @Shadow @Final private BiMap<Identifier, T> idToEntry;
    private Random random = new Random();

	@Inject(method = "get(Lnet/minecraft/util/Identifier;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
	private void getRep(Identifier id, CallbackInfoReturnable<T> cir) {
		if (checkIfSafe(this.idToEntry.get(id))) {
			cir.setReturnValue(this.getRandom(random));
		}
	}


    @Inject(method = "getId", at = @At("HEAD"), cancellable = true)
    private void getIdRep(T entry, CallbackInfoReturnable<Identifier> cir) {
        if (checkIfSafe(entry)){
            Identifier identifier = this.idToEntry.inverse().get(this.getRandom(random));
            cir.setReturnValue(identifier);
        }
    }

    private boolean checkIfSafe(Object entry) {
	    return entry instanceof Item || entry instanceof EntityAttribute || entry instanceof Potion ||
                entry instanceof Fluid || entry instanceof VillagerProfession || entry instanceof Enchantment;
    }
}
