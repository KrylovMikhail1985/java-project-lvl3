package hexlet.code;


import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
//import hexlet.code.schemas.NumberSchema;
//import hexlet.code.schemas.StringSchema;
//
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();
        System.out.println(schema.isValid("human1")); // true
        System.out.println(schema.isValid(null)); // true
        final int number = 99;
        System.out.println(schema.isValid(number)); // true
        System.out.println("=======================");

        final int minLength = 2;
        final int maxLength = 8;
        final int size = 1;


        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required().minLength(minLength).contains("as"));
        schemas.put("age", v.number().required().positive().range(minLength, maxLength));
        schemas.put("map", v.map().required().sizeof(size));
//        schemas.put("name", v.string().required());
//        schemas.put("age", v.number());
//        schemas.put("map", v.map().required());

        schema.shape(schemas);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Haska");
        final int age = 6;
        human1.put("age", age);
        human1.put("map", data);
        System.out.println(schema.isValid(human1)); // true
        System.out.println("=======================");

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "null");
        System.out.println(schema.isValid(human2)); // false
        human2.put("age", null);
        System.out.println(schema.isValid(human2)); // false
        human2.put("map", null);
        System.out.println(schema.isValid(human2)); // false

//        Validator v = new Validator();
//
//        MapSchema schema = v.map();
//
//        System.out.println(schema.isValid("data")); // false


//        Validator v = new Validator();
//
//        MapSchema schema = v.map();
//
//        Map<String, BaseSchema> schemas = new HashMap<>();
//        schemas.put("name", v.string().required().minLength(3));
//        schemas.put("age", v.number().positive().range(5, 160));
//        schema.shape(schemas);
//
//        Map<String, Object> human1 = new HashMap<>();
//        human1.put("name", "Kolya");
//        human1.put("age", 100);
//        System.out.println(schema.isValid(human1)); // true
//
//        Map<String, Object> human2 = new HashMap<>();
//        human2.put("name", "Maya");
//        human2.put("age", null);
//        System.out.println(schema.isValid(human2)); // true
//
//        Map<String, Object> human3 = new HashMap<>();
//        human3.put("name", "");
//        human3.put("age", null);
//        System.out.println(schema.isValid(human3)); // false
//
//        Map<String, Object> human4 = new HashMap<>();
//        human4.put("name", "Valya");
//        human4.put("age", -5);
//        System.out.println(schema.isValid(human4)); // false
//
//        System.out.println("=======================");
//
//        NumberSchema schem = v.number();
//
//        System.out.println(schem.isValid(null)); // true
//        System.out.println(schem.isValid("string")); // true
//        schem.required();
//
//        System.out.println(schem.isValid(null)); // false
//        System.out.println(schem.isValid("string")); // false
//        System.out.println(schem.isValid(0)); // true
//        System.out.println(schema.isValid("5")); // false
//        schema.range(5, -5);
//
//        System.out.println(schema.isValid(5)); // true
//        System.out.println(schema.isValid(-4)); // true
//        System.out.println(schema.isValid(0)); // true
//        System.out.println(schema.isValid(-9)); // false
//        System.out.println(schema.isValid(11)); // false
//
//        StringSchema schema = v.string();
//
//        System.out.println(schema.isValid("")); // true
//        System.out.println(schema.isValid(null)); // true
//
//        System.out.println(schema.contains("fox").isValid("what does the fox say")); // true
//        System.out.println(schema.contains("hexlet").isValid("what does the fox say")); // false
//        System.out.println(schema.contains("what").isValid("what does the fox say")); // true
//        System.out.println(schema.isValid(null)); // false
//        schema.required();
//
//        System.out.println(schema.isValid("what does the fox say")); // true
//        System.out.println(schema.isValid("hexlet")); // false
//
//        System.out.println(schema.isValid(null)); // false
//        System.out.println(schema.isValid("")); // false
//
//        System.out.println(schema.contains("what").isValid("what does the fox say")); // true
//        System.out.println(schema.contains("whatthe").isValid("what does the fox say")); // false

//        System.out.println(schema.isValid("what does the fox say")); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")
    }
}
