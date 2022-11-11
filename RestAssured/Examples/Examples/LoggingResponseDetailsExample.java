package Examples;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Examples.Example_RequestSpec.requestSpec;
import static Examples.Example_ResponseSpec.responseSpec;
import static io.restassured.RestAssured.given;

public class LoggingResponseDetailsExample {

    @Test
    public void loggingAllResponseDetails() {
        Response response = given()
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

        // Assertion with response specification
        response.then()
                .log().all() // Log all response details
                .spec(responseSpec); // Use resposeSpec for validation
    }


    @Test
    public void loggingResponseHeaders() {
        Response response = given()
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

        // Assertion with response specification
        response.then()
                .log().headers() // Log only response headers
                .spec(responseSpec); // Use resposeSpec for validation
    }


    @Test
    public void loggingResponseBody() {
        Response response = given()
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

        // Assertion with response specification
        response.then()
                .log().body() // Log only response body
                .spec(responseSpec); // Use resposeSpec for validation
    }

}
