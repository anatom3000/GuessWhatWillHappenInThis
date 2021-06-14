package fr.anatom3000.gwwhit;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.IOUtils;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

import static fr.anatom3000.gwwhit.GWWHIT.LOGGER;

public class Python {

	private static final String CODE;

	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String code;
		try ( InputStream s = loader.getResourceAsStream("init.py") ) {
			code = IOUtils.toString( Objects.requireNonNull(s), StandardCharsets.UTF_8 );
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
			code = "";
		}
		CODE = code;
	}

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public static void load() {
		LOGGER.info("[GWWHIT] initializing python system!");
		Properties preProperties = System.getProperties(), postProperties = new Properties();
		preProperties.put( "python.home", FabricLoader.getInstance().getGameDir().toString() );
		preProperties.put(
				"python.path",
				FabricLoader.getInstance().getModContainer("gwwhit").get().getRootPath().toString() + "\\Lib"
		);
		PySystemState.initialize(
				preProperties,
				postProperties,
				new String[] { "" }
		);
		LOGGER.info("[GWWHIT] Python Initialized!");
		try ( PythonInterpreter python = new PythonInterpreter() ) {
			python.setErr(System.err);
			python.setOut(System.out);
			python.exec(CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
