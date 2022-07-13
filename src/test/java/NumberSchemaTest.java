import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        boolean actual = schema.isValid(ten);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest4() {
        boolean expected = false;
        schema.required();
        boolean actual = schema.isValid("5");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest5() {
        boolean expected = true;
        schema.required();
        boolean actual = schema.positive().isValid(ten);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest6() {
        boolean expected = false;
        schema.required();
        boolean actual = schema.positive().isValid(-ten);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest7() {
        boolean expected = true;
        schema.required().range(five, ten);
        boolean actual = schema.isValid(eight);
        assertEquals(expected, actual);
        actual = schema.isValid(five);
        assertEquals(expected, actual);
        actual = schema.isValid(ten);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest8() {
        boolean expected = false;
        schema.required().range(five, ten);
        boolean actual = schema.isValid(fore);
        assertEquals(expected, actual);
        actual = schema.isValid(-five);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest9() {
        boolean expected = true;
        schema.required().range(-eight, five);
        boolean actual = schema.isValid(-fore);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest10() {
        boolean expected = false;
        schema.positive();
        boolean actual = schema.isValid(null);
        assertEquals(expected, actual);
    }
}
