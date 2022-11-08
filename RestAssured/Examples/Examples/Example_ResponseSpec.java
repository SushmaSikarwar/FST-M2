package Examples;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.is;

public interface Example_ResponseSpec {
    ResponseSpecification responseSpec = new ResponseSpecBuilder()
// Check status code in response
            .expectStatusCode(200)
// Check response content type
            .expectContentType("application/json")
// Check size of the array in a JSON response
            .expectBody("size()", is(3))
// Build response specification
            .build();
}
