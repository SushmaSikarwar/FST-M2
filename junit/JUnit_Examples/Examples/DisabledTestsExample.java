package Examples;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.Assert.assertEquals;


@Disabled("Disabled until bug #2020 has been fixed!")
public class DisabledTestsExample {

    // All test methods are ignored
    @Test
    void test1Plus1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void test2Plus2() {
        assertEquals(4, 2 + 2);
    }
}
