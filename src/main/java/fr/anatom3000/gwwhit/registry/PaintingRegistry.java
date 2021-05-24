package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.GuessWhatWillHappenInThisMod;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.registry.Registry;

public class PaintingRegistry {

    //Azzy was here

    public static void register() {
        register("beecensor", 128, 128);
        register("very_bee", 128, 64);
        register("bee", 64, 32);
        register("bless", 32, 32);
        register("succubi", 48, 48);
        register("alex", 48, 48);
    }

    private static void register(String id, int height, int width) {
        Registry.register(Registry.PAINTING_MOTIVE, GuessWhatWillHappenInThisMod.ID(id), new PaintingMotive(width, height));
    }
}
