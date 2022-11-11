package Examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Examples.Example_RequestSpec.requestSpec;
import static io.restassured.RestAssured.given;

public class LoggingRequestDetailsExample {


    @Test
    public void loggingAllRequestDetails() {
        Response response = given()
                .log().all() // Log all request details
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

    }


    @Test
    public void loggingRequestParameters() {
        Response response = given()
                .log().params() // Log only request parameters
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

    }


    @Test
    public void loggingRequestHeaders() {
        Response response = given()
                .log().headers() // Log only request headers
                .spec(requestSpec) // Use requestSpec
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

    }

    @Test
    public void loggingRequestBody() {
        String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";

        Response response = given()
                .log().body() // Log request body
                .spec(requestSpec) // Use requestSpec
                .contentType(ContentType.JSON) // Set headers
                .body(reqBody) // Add request body
                .when().post(); // Send POST request

    }


}
