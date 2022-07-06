import hexlet.code.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void apptest1() {
        String expected = "It's working!";
        String actual = App.greeting();
        Assertions.assertEquals(expected, actual);
    }
}
