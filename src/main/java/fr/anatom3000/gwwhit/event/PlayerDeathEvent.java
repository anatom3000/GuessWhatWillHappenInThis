package fr.anatom3000.gwwhit.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;

/**
 * @author ENDERZOMBI102
 */
@FunctionalInterface
public interface PlayerDeathEvent {

    Event<PlayerDeathEvent> PLAYER_DEATH = EventFactory.createArrayBacked(
            PlayerDeathEvent.class,
            listeners -> player -> {
                for (PlayerDeathEvent listener : listeners) {
                    listener.onDeath( player );
                }
            }
    );

    void onDeath(PlayerEntity player);
}

