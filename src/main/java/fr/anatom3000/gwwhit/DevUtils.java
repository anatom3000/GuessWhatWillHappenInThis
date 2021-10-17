package fr.anatom3000.gwwhit;

import com.google.gson.Gson;
import fr.anatom3000.gwwhit.config.data.MainConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// This is not included in the distribution and just contains things useful for devs
public class DevUtils {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));

        free:
        while (true) {
            switch (in.readLine()) {
                case "dump config" -> System.out.println(new Gson().toJson(new MainConfig()));
                case "exit" -> {
                    break free;
                }
            }
        }
    }
}
