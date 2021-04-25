package fr.anatom3000.gwwhit.mixin;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Registry.class)
public abstract class RegistryMixin<T> {
    @Shadow @Nullable public abstract T get(@Nullable RegistryKey<T> key);

    @Shadow @Nullable public abstract T get(@Nullable Identifier id);

    /**
     * @author Patbox
     */
    @Overwrite
    public T getOrThrow(RegistryKey<T> key) {
        T object = this.get(key);
        if (object == null && ((Object) this) instanceof DefaultedRegistry) {
            return this.get(((DefaultedRegistry) (Object) (this)).getDefaultId());
        } else if (object == null) {
            throw new IllegalStateException("Missing: " + key);
        } else {
            return object;
        }
    }
}
