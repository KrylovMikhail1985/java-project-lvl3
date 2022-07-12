import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemaTest {
//    @BeforeAll
//    public static void beforeEach() {
//        Validator v = new Validator();
//        StringSchema schema = v.string();
//    }
    @Test
    public void stringSchemaTest1() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = true;
        final int min = 6;
        boolean actual = schema.required()
                .contains("I")
                .contains("Love")
                .minLength(min)
                .isValid("I Love you!!!");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest2() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = false;
        final int min = 6;
        boolean actual = schema.required()
                .contains("I")
                .contains("Hate")
                .minLength(min)
                .isValid("I Love you!!!");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest3() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = false;
        final int min = 89;
        boolean actual = schema.required()
                .contains("I")
                .contains("Love")
                .minLength(min)
                .isValid("I Love you!!!");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest4() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = true;
        boolean actual = schema.required()
                .isValid("I Love you!!!");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest5() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = false;
        boolean actual = schema.required()
                .isValid("");
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest6() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = false;
        boolean actual = schema.required()
                .isValid(null);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest7() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = true;
        boolean actual = schema.isValid(null);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest8() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        boolean expected = false;
        boolean actual = schema.contains("hate")
                .isValid(null);
        assertEquals(expected, actual);
    }
    @Test
    public void stringSchemaTest9() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        final int min = 5;
        boolean expected = false;
        boolean actual = schema.minLength(min)
                .isValid(null);
        assertEquals(expected, actual);
    }
}
