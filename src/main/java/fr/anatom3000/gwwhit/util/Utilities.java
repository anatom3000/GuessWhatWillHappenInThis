package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.commandline.ModUpdater;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

/**
 * DONT USE ANY MC/MOD CLASSES HERE
 */
public final class Utilities {
	public static InputStream getResource(@NotNull String name) {
		return Utilities.class.getResourceAsStream(name);
	}

	public static URL getResourceURL(@NotNull String name) {
		return Utilities.class.getResource(name);
	}

	public static <T> boolean contains(T[] array, @NotNull T object) {
		if (array == null)
			return false;
		for (T value : array) {
			if ( object.equals(value) )
				return true;
		}
		return false;
	}

	public static Path getJarLocation() throws URISyntaxException {
		return Path.of( ModUpdater.class.getProtectionDomain().getCodeSource().getLocation().toURI() );
	}
}
