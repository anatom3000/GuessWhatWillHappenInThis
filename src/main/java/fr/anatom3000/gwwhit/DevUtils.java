package fr.anatom3000.gwwhit;

import com.google.gson.Gson;
import fr.anatom3000.gwwhit.config.SyncOptions;
import fr.anatom3000.gwwhit.config.data.MainConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

// This is not included in the distribution and just contains things useful for devs
public class DevUtils {
    public static void main(String[] args) throws Exception {
        var in = new BufferedReader(new InputStreamReader(System.in));

        free:
        while (true) {
            switch (in.readLine()) {
                case "dump_config" -> System.out.println(new Gson().toJson(new MainConfig()));
                case "validate_sync_options" -> {
                    var temp = new ArrayList<>(Arrays.stream(MainConfig.class.getFields()).filter(field -> field.getModifiers() == Modifier.PUBLIC).toList());
                    var fields = new ArrayList<Field>();
                    while (temp.size() > 0) {
                        var field = temp.remove(0);
                        fields.add(field);
                        temp.addAll(Arrays.stream(field.getType().getFields()).filter(field0 -> field0.getModifiers() == Modifier.PUBLIC).toList());
                    }
                    for (Field field : fields) {
                        if (field.getAnnotation(SyncOptions.class) == null) {
                            System.out.println(field.getDeclaringClass().getTypeName() + "." + field.getName() + " doesn't have sync options!");
                        }
                    }

                    System.out.println("Done.");
                }
                case "exit" -> {
                    break free;
                }
            }
        }
    }
}
