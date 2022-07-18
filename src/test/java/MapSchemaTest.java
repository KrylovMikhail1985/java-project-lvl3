import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public final class MapSchemaTest {
    private Validator v;
    private MapSchema schema;
    private Map<String, BaseSchema> schemas;
    private final int fifty = 50;
    private final int five = 5;

    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.map();
        schemas = new HashMap<>();
        schemas.put("name", v.string().minLength(2));
        schemas.put("age", v.number().positive());
    }
    @Test
    public void mapSchemaTest1() {
        assertTrue(schema.isValid(null));
    }
    @Test
    public void mapSchemaTest2() {
        schema.required();
        assertFalse(schema.isValid(null));
    }
    @Test
    public void mapSchemaTest3() {
        schema.required();
        assertTrue(schema.isValid(new HashMap()));
    }
    @Test
    public void mapSchemaTest4() {
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean actual = schema.isValid(data);
        assertTrue(actual);
    }
    @Test
    public void mapSchemaTest5() {
        schema.required().sizeof(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
    @Test
    public void mapSchemaTest6() {
        assertTrue(schema.isValid("Map"));
    }
    @Test
    public void mapSchemaTest7() {
        schema.required();
        assertFalse(schema.isValid("Map"));
    }
    @Test
    public void mapSchemaTest8() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", fifty);
        assertTrue(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest9() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", null);
        assertTrue(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest10() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "");
        human.put("age", fifty);
        assertFalse(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest11() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", -fifty);
        assertFalse(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest12() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", "88");
        assertFalse(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest13() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", 0);
        assertFalse(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest14() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("age", fifty);
        human.put("sex", "man");
        assertTrue(schema.isValid(human));
    }
    @Test
    public void mapSchemaTest15() {
        schema.sizeof(0);
        assertTrue(schema.isValid(new HashMap<>()));
    }
    @Test
    public void mapSchemaTest16() {
        schema.sizeof(1);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }
    @Test
    public void mapSchemaTest18() {
        schema.sizeof(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
        data.put("key3", "value3");
        assertFalse(schema.isValid(data));
    }
    @Test
    public void mapSchemaTest19() {
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", fifty);
        assertTrue(schema.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2)); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -five);
        assertFalse(schema.isValid(human4)); // false
    }
    @Test
    public void mapSchemaTest20() {
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", fifty);
        assertTrue(schema.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", "99");
        assertFalse(schema.isValid(human2)); // true
    }
    @Test
    public void mapSchemaTest22() {
        Map<String, String> data1 = new HashMap<>();
        Map<String, String> data2 = new LinkedHashMap<>();
        assertTrue(schema.isValid(data1));
        assertTrue(schema.isValid(data2));
        assertTrue(schema.isValid("ppp"));
        schema.required();
        assertTrue(schema.isValid(data1));
        assertTrue(schema.isValid(data2));
        assertFalse(schema.isValid("ppp"));
    }
}
