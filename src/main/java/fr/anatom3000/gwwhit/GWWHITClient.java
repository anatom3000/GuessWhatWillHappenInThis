package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.command.Commands;
import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.registry.EntityRegistry;
import fr.anatom3000.gwwhit.registry.EventListeners;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

import fr.anatom3000.gwwhit.client.render.entity.SentientArrowRenderer;

public class GWWHITClient implements ClientModInitializer {
    public static final Identifier WHISTLE_SOUND = new Identifier("gwwhit:whatsapp_whistle");
    public static final SoundEvent WHISTLE_SOUND_EVENT = new SoundEvent(WHISTLE_SOUND);
    public static final Identifier MOJAAAANG_SOUND = new Identifier("gwwhit:mojaaaang");
    public static final SoundEvent MOJAAAANG_SOUND_EVENT = new SoundEvent(MOJAAAANG_SOUND);
    public static final Identifier ROCK_SOUND = getId("rock");
    public static final SoundEvent ROCK_SOUND_EVENT = new SoundEvent(ROCK_SOUND);

    @SuppressWarnings("deprecation")
	@Override
    public void onInitializeClient() {
        NewMaterials.onInitializeClient();
        EventListeners.registerClient();
        Commands.registerClient();
        Registry.register(Registry.SOUND_EVENT, WHISTLE_SOUND, WHISTLE_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, MOJAAAANG_SOUND, MOJAAAANG_SOUND_EVENT);
        Registry.register(Registry.SOUND_EVENT, ROCK_SOUND, ROCK_SOUND_EVENT);
        // server needs to know about these, unless somebody wants to fuck with the SentientArrow code
        Registry.register(Registry.SOUND_EVENT, GWWHIT.SNIPER_NS, GWWHIT.SNIPER_NS_EVENT); // Good shot mate!
        Registry.register(Registry.SOUND_EVENT, GWWHIT.SNIPER_THX, GWWHIT.SNIPER_THX_EVENT); // 'preciate it.

        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SENTIENT_ARROW_ENTITY, (ctx) -> new SentientArrowRenderer(ctx));
        
        ClientPlayNetworking.registerGlobalReceiver(GWWHIT.CONFIG_SYNC_ID, (client, networkHandler, data, sender) -> {
            String version = data.readString();
            String config = data.readString();

            client.execute(() -> ConfigManager.fromPacket(version, config));
        });
    }
}
