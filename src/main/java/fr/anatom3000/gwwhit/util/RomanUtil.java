package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.config.ConfigManager;

import java.util.TreeMap;

public class RomanUtil {

	private final static TreeMap<Integer, String> map = new TreeMap<>() {{
		put(1000, "M");
		put(900, "CM");
		put(500, "D");
		put(400, "CD");
		put(100, "C");
		put(90, "XC");
		put(50, "L");
		put(40, "XL");
		put(10, "X");
		put(9, "IX");
		put(5, "V");
		put(4, "IV");
		put(1, "I");
	}};

	public static String toRoman(int number) {
		int l =  map.floorKey(number);
		if ( number == l ) {
			return map.get(number);
		}
		return map.get(l) + toRoman(number-l);
	}

	public static float getScale(String string) {
		if (string.length() > 5) return .45f;
		else if (string.length() > 3) {
			return .5f;
		} else if (string.length() == 3) {
			return .75f;
		}
		return 1f;
	}

}
