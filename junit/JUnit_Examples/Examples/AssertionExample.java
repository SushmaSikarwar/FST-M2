package Examples;

import org.testng.annotations.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;


public class AssertionExample {

    @Test
    void firstNameStartsWithJ() {
        Person person = new Person("John", "Doe");

        // Assertion
        assertTrue(person.getFirstName().startsWith("J")); //Pass
        assertFalse(person.getFirstName().startsWith("J")); // Fail
    }

    @Test
    void personHasFirstName() {
        Person person = new Person("John", "Doe");

        // Assertion
        assertNotNull(person.getFirstName()); //Pass
        assertNull(person.getFirstName()); //Fail
    }

    @Test
    void firstAndLastNameMatches() {
        Person person = new Person("John", "Doe");

        // Grouped Assertion
        assertAll("person" , () -> assertEquals("John", person.getFirstName()), // Assertion for first name

                    () -> assertEquals("Doe", person.getLastName())); // Assertion for last name
    }

}