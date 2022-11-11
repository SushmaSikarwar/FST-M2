package Examples;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.Assert.assertThrows;

public class ExceptionsTest {

    @Test
    public void testUsernameIsNull() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                User user = new User();
                user.setName(null);
            }
        });
    }

    @Test
    public void testUsernameIsNullLambda() {
            assertThrows(IllegalArgumentException.class, () -> {
                User user = new User();
                user.setName(null);
            });
        }
}
