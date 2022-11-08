package Examples;

import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Test_ResponseSpec {
    // Declare response specification
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
// Create response specification
        responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Check if response contains name property
                .expectBody("status", equalTo("alive"))
                // Build response specification
                .build();
    }

    @Test
    public void testPet1() {
        Response response = given().setContentType(ContentType.JSON) // Set content type
                .pathParam("petId", "77232") // Set path parameter
                .get("/{petId}"); // Send GET request

// Print response
        String body = response.getBody().asPrettyString();
        System.out.println(body);

// Assertion with response specification
        response.then().spec(responseSpec);
    }
}
