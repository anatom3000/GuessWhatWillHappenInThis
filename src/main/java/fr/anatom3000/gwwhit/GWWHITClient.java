package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.command.Commands;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.registry.EventListeners;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

public class GWWHITClient implements ClientModInitializer {
    public static final Identifier WHISTLE_SOUND = new Identifier("gwwhit:whatsapp_whistle");
    public static final SoundEvent WHISTLE_SOUND_EVENT = new SoundEvent(WHISTLE_SOUND);
    public static final Identifier MOJAAAANG_SOUND = new Identifier("gwwhit:mojaaaang");
    public static final SoundEvent MOJAAAANG_SOUND_EVENT = new SoundEvent(MOJAAAANG_SOUND);
    public static final Identifier ROCK_SOUND = getId("rock");
    public static final SoundEvent ROCK_SOUND_EVENT = new SoundEvent(ROCK_SOUND);


    @Override
    public void onInitializeClient() {
        NewMaterials.onInitializeClient();
        EventListeners.registerClient();
        Commands.registerClient();
        Registry.register(Registry.SOUND_EVENT, WHISTLE_SOUND, WHISTLE_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, MOJAAAANG_SOUND, MOJAAAANG_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, ROCK_SOUND, ROCK_SOUND_EVENT);

        ClientPlayNetworking.registerGlobalReceiver(GWWHIT.CONFIG_SYNC_ID, (client, networkHandler, data, sender) -> {
            String version = data.readString();
            String config = data.readString();

            client.execute(() -> {
                ConfigManager.fromPacket(version, config);
            });
        });
    }
}
