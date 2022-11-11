package Examples;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.Assert.assertEquals;

public class DisabledTestMethodExample {

    // Ignored test method
    @Disabled("Disabled until CustomerService is up!")
    @Test
    void testCustomerServiceGet() {
        assertEquals(2, 1 + 1);
    }

    // Test method that will execute
    @Test
    void test3Plus3() {
        assertEquals(6, 3 + 3);
    }
}
