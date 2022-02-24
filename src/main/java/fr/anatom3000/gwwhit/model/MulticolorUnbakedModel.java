package fr.anatom3000.gwwhit.model;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

public class MulticolorUnbakedModel implements UnbakedModel {
    private static final SpriteIdentifier SPRITE_ID = new SpriteIdentifier(
            PlayerScreenHandler.BLOCK_ATLAS_TEXTURE,
            getId("block/multicolor_block")
    );
    private static final Identifier DEFAULT_BLOCK_MODEL = new Identifier("minecraft:block/block");

    @Override
    public Collection<Identifier> getModelDependencies() {
        return List.of( DEFAULT_BLOCK_MODEL );
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return List.of( SPRITE_ID );
    }

    @Nullable
    @Override
    public BakedModel bake(ModelLoader loader, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {
        // Load the default block model
        JsonUnbakedModel defaultBlockModel = (JsonUnbakedModel) loader.getOrLoadModel(DEFAULT_BLOCK_MODEL);
        // sprite
        var sprite = textureGetter.apply(SPRITE_ID);
        // Build the mesh using the Renderer API
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        assert renderer != null;
        MeshBuilder builder = renderer.meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        for ( Direction direction : Direction.values() ) {
            // Add a new face to the mesh
            emitter.square( direction, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f );
            // Set the sprite of the face, must be called after .square()
            // We haven't specified any UV coordinates, so we want to use the whole texture. BAKE_LOCK_UV does exactly that.
            emitter.spriteBake(0, sprite, MutableQuadView.BAKE_LOCK_UV);
            // Enable texture usage
            emitter.spriteColor(0, -1, -1, -1, -1);
            // Add the quad to the mesh
            emitter.emit();
        }

        return new MulticolorBakedModel( builder.build(), defaultBlockModel.getTransformations(), sprite );
    }
}
