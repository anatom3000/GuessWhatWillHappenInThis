package fr.anatom3000.gwwhit.test;

import fr.anatom3000.gwwhit.config.SyncOptions;
import fr.anatom3000.gwwhit.config.data.MainConfig;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;

public class ConfigTest {
    @Test
    public void checkSyncOptions() {
        var temp = new ArrayList<>(Arrays.stream(MainConfig.class.getFields()).filter(field -> field.getModifiers() == Modifier.PUBLIC).toList());
        var fields = new ArrayList<Field>();
        while (temp.size() > 0) {
            var field = temp.remove(0);
            fields.add(field);
            temp.addAll(Arrays.stream(field.getType().getFields()).filter(field0 -> field0.getModifiers() == Modifier.PUBLIC).toList());
        }
        for (Field field : fields) {
            Assertions.assertNotNull(field.getAnnotation(SyncOptions.class), field.getDeclaringClass().getTypeName() + "." + field.getName() + " doesn't have a SyncOptions annotation!");
        }
    }
}
