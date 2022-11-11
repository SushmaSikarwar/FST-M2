package Examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void addNumbers() {
        // Assertion
        assertEquals(3, calculator.add(1, 2)); // Passes
        assertNotEquals(3, calculator.add(1, 2)); // Fails
    }

    @Test
    void addNumbersAssertCustom() {
        // Assertion with a custom message
        // that will be displayed if the test fails
        assertEquals(String.valueOf(3), calculator.add(1, 2), "1 + 2 should equal 3");
    }
}
