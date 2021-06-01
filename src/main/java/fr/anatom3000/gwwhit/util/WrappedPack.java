package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.config.ModConfig;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.metadata.ResourceMetadataReader;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

public class WrappedPack implements ResourcePack {
    private final ResourcePack pack;
    @Override
    public InputStream openRoot(String fileName) throws IOException {
        return pack.openRoot(fileName);
    }

    @Override
    public InputStream open(ResourceType type, Identifier id) throws IOException {
        if (ModConfig.getLoadedConfig().misc.blyatSounds && id.getPath().endsWith(".ogg"))
            return GWWHIT.CLASS_LOADER.getResourceAsStream("assets/gwwhit/sounds/blyat.ogg");
        return pack.open(type, id);
    }

    @Override
    public Collection<Identifier> findResources(ResourceType type, String namespace, String prefix, int maxDepth, Predicate<java.lang.String> pathFilter) {
        return pack.findResources(type, namespace, prefix, maxDepth, pathFilter);
    }

    @Override
    public boolean contains(ResourceType type, Identifier id) {
        return pack.contains(type, id);
    }

    @Override
    public Set<String> getNamespaces(ResourceType type) {
        return pack.getNamespaces(type);
    }

    @Nullable
    @Override
    public <T> T parseMetadata(ResourceMetadataReader<T> metaReader) throws IOException {
        return pack.parseMetadata(metaReader);
    }

    @Override
    public String getName() {
        return pack.getName();
    }

    @Override
    public void close() {
        pack.close();
    }

    public WrappedPack(ResourcePack pack) {
        this.pack = pack;
    }
}
