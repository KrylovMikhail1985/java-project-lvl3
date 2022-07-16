import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class NumberSchemaTest {
    private  Validator v;
    private  NumberSchema schema;
    private final int fore = 4;
    private final int five = 5;
    private final int ten = 10;
    private final int eight = 8;

    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.number();
    }
    @Test
    public void numberSchemaTest1() {
        assertTrue(schema.isValid(null));
    }
    @Test
    public void numberSchemaTest2() {
        schema.required();
        assertFalse(schema.isValid(null));
    }
    @Test
    public void numberSchemaTest3() {
        schema.required();
        assertTrue(schema.isValid(ten));
    }
    @Test
    public void numberSchemaTest4() {
        schema.required();
        assertFalse(schema.isValid("5"));
    }
    @Test
    public void numberSchemaTest5() {
        schema.required();
        assertTrue(schema.positive().isValid(ten));
    }
    @Test
    public void numberSchemaTest6() {
        schema.required();
        assertFalse(schema.positive().isValid(-ten));
    }
    @Test
    public void numberSchemaTest7() {
        schema.required().range(five, ten);
        assertTrue(schema.isValid(eight));
        assertTrue(schema.isValid(five));
        assertTrue(schema.isValid(ten));
    }
    @Test
    public void numberSchemaTest8() {
        schema.required().range(five, ten);
        assertFalse(schema.isValid(fore));
        assertFalse(schema.isValid(-five));
    }
    @Test
    public void numberSchemaTest9() {
        schema.range(-eight, five);
        assertTrue(schema.isValid(fore));
        assertTrue(schema.isValid(five));
        assertTrue(schema.isValid(-eight));
        assertTrue(schema.isValid(0));
        assertFalse(schema.isValid(-ten));
        assertFalse(schema.isValid(ten));
    }
    @Test
    public void numberSchemaTest10() {
        schema.positive();
        assertTrue(schema.isValid(null));
    }
    @Test
    public void numberSchemaTest11() {
        schema.required();
        assertFalse(schema.positive().isValid(0));
    }
    @Test
    public void numberSchemaTest12() {
        assertFalse(schema.positive().isValid(0));
    }
    @Test
    public void numberSchemaTest13() {
        schema.required();
        assertTrue(schema.isValid(0));
    }
    @Test
    public void numberSchemaTest14() {
        schema.required();
        assertFalse(schema.isValid(-five));
    }
    @Test
    public void numberSchemaTest15() {
        assertTrue(schema.isValid("99"));
    }
}
