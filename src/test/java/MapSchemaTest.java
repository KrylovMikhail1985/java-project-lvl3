import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class MapSchemaTest {
    private Validator v;
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.mapShema();
    }
    @Test
    public void stringSchemaTest1() {
        boolean expected = true;
        boolean actual = schema.isValid(null);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest2() {
        boolean expected = false;
        schema.required();
        boolean actual = schema.isValid(null);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest3() {
        boolean expected = true;
        schema.required();
        boolean actual = schema.isValid(new HashMap());
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest4() {
        boolean expected = true;
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean actual = schema.isValid(data);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest51() {
        boolean expected = false;
        schema.required().sizeOf(2);
        Map<String, String> data = new HashMap<>();
        data.put("key2", "value2");
        assertEquals(expected, schema.isValid(data));
    }
    @Test
    public void stringSchemaTest52() {
        boolean expected = true;
        schema.required().sizeOf(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        assertEquals(expected, schema.isValid(data));
    }
    @Test
    public void stringSchemaTest6() {
        boolean expected = true;
        boolean actual = schema.isValid("Map");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest7() {
        schema.required();
        boolean expected = false;
        boolean actual = schema.isValid("Map");
        assertEquals(expected, actual);
    }
}
