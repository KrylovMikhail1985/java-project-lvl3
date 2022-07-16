import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public final class MapSchemaTest {
    private Validator v;
    private MapSchema schema;
    private Map<String, BaseSchema> schemas;
    private final int fifty = 50;

    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.map();
        schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
    }
    @Test
    public void stringSchemaTest1() {
        assertTrue(schema.isValid(null));
    }
    @Test
    public void stringSchemaTest2() {
        schema.required();
        assertFalse(schema.isValid(null));
    }
    @Test
    public void stringSchemaTest3() {
        schema.required();
        assertTrue(schema.isValid(new HashMap()));
    }
    @Test
    public void stringSchemaTest4() {
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean actual = schema.isValid(data);
        assertTrue(actual);
    }
    @Test
    public void stringSchemaTest5() {
        schema.required().sizeof(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
    @Test
    public void stringSchemaTest6() {
        boolean actual = schema.isValid("Map");
        assertTrue(actual);
    }
    @Test
    public void stringSchemaTest7() {
        schema.required();
        boolean actual = schema.isValid("Map");
        assertFalse(actual);
    }
    @Test
    public void stringSchemaTest8() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", fifty);
        assertTrue(schema.isValid(human));
    }
    @Test
    public void stringSchemaTest9() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", null);
        assertTrue(schema.isValid(human));
    }
    @Test
    public void stringSchemaTest10() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "");
        human.put("age", fifty);
        assertFalse(schema.isValid(human));
    }
    @Test
    public void stringSchemaTest11() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", -fifty);
        assertFalse(schema.isValid(human));
    }
    @Test
    public void stringSchemaTest12() {
        schema.shape(schemas);
        Map<String, Object> human = new HashMap<>();
        human.put("name", "Kolya");
        human.put("age", "88");
        assertFalse(schema.isValid(human));
    }
}

