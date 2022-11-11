package Examples;


import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.Random.class)
public class RandomAnnotation {

    @Test
    void testZ() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testA() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testY() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testE() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void testB() {
        assertEquals(2, 1 + 1);
    }

}
