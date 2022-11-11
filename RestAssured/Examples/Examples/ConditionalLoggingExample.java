package Examples;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.greaterThan;

public class ConditionalLoggingExample {

    @Test
    public void whenLogResponseIfErrorOccurred_thenSuccess() {
        // Log then error occurs
        when().get("/users/saahil")
                .then().log().ifError();
        // Log when status code is 500
        when().get("/users/saahil")
                .then().log().ifStatusCodeIsEqualTo(500);
        // Log when status code is greater than 200
        when().get("/users/saahil")
                .then().log().ifStatusCodeMatches(greaterThan(200));
    }

    @Test
    public void whenLogOnlyIfValidationFailed_thenSuccess() {
        // Log request if validation fails
        given().log().ifValidationFails()
                .when().get("/users/saahil")
                .then().statusCode(200);

        // Log response if validation fails
        when().get("/users/saahil")
                .then().log().ifValidationFails().statusCode(200);
    }

}
