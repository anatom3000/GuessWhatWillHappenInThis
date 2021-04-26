package fr.anatom3000.gwwhit.util;

import java.util.stream.Stream;

public class CheatCodes {
	public static final String CHEAT1 = "POWEROVERWHELMING";
	public static final String CHEAT2 = "PIGSONTHEWING";
	public static final String CHEAT3 = "FLASHAAAAA";
	public static final String CHEAT4 = "MOREDAKKA";
	public static final String CHEAT5 = "IDKFA";
	public static final String CHEAT6 = "COWSCOWSCOWS";
	public static final String CHEAT7 = "HOWDOYOUTURNTHISON";
	public static final String CHEAT8 = "NEEEERD";
	public static final String CHALLENGE = "MOD THIS";
	public static final String[] ALL_CHEATS = new String[]{"POWEROVERWHELMING", "PIGSONTHEWING", "FLASHAAAAA", "MOREDAKKA", "IDKFA", "COWSCOWSCOWS", "HOWDOYOUTURNTHISON", "NEEEERD"};
	public static final int MAX_CHEAT_LEN;

	static {
		MAX_CHEAT_LEN = Stream.of(ALL_CHEATS).mapToInt(String::length).reduce(0, Math::max);
	}
}