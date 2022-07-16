import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    private Validator v;
    private StringSchema schema;
    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.string();
    }
    @Test
    public void stringSchemaTest1() {
        final int min = 6;
        boolean actual = schema.required()
                .contains("I")
                .contains("Love")
                .minLength(min)
                .isValid("I Love you!!!");
        assertTrue(actual);
    }
    @Test
    public void stringSchemaTest2() {
        final int min = 6;
        boolean actual = schema.required()
                .contains("I")
                .contains("Hate")
                .minLength(min)
                .isValid("I Love you!!!");
        assertFalse(actual);
    }
    @Test
    public void stringSchemaTest3() {
        final int min = 89;
        boolean actual = schema.required()
                .contains("I")
                .contains("Love")
                .minLength(min)
                .isValid("I Love you!!!");
        assertFalse(actual);
    }
    @Test
    public void stringSchemaTest4() {
        boolean actual = schema.required()
                .isValid("I Love you!!!");
        assertTrue(actual);
    }
    @Test
    public void stringSchemaTest5() {
        assertFalse(schema.required().isValid(""));
    }
    @Test
    public void stringSchemaTest6() {
        assertFalse(schema.required().isValid(null));
    }
    @Test
    public void stringSchemaTest7() {
        assertTrue(schema.isValid(null));
    }
    @Test
    public void stringSchemaTest8() {
        assertFalse(schema.contains("hate").isValid(null));
    }
    @Test
    public void stringSchemaTest9() {
        final int min = 5;
        assertFalse(schema.minLength(min).isValid(null));
    }
}
