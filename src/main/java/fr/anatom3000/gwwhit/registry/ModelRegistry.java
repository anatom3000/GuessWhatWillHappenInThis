package fr.anatom3000.gwwhit.registry;

import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static fr.anatom3000.gwwhit.GWWHIT.LOGGER;

public class ModelRegistry implements ModelResourceProvider {
    public static final Map< Identifier, Class<? extends UnbakedModel> > MODELS = new HashMap<>() {{
    }};

    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext ) {
        // very cursed, I LIKE IT!
        if ( MODELS.containsKey( identifier ) )
            try {
                return MODELS.get( identifier ).getConstructor().newInstance();
            } catch ( InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e ) {
                LOGGER.error( "Failed to create unbaked model for " +  identifier, e );
            }
        return null;
    }

}
