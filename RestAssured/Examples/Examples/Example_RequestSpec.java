package Examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public interface Example_RequestSpec {

    RequestSpecification requestSpec = new RequestSpecBuilder()
// Set content type
            .setContentType(ContentType.JSON)
// Set base URL
            .setBaseUri("https://petstore.swagger.io/v2/pet")
// Add query parameters
            .addQueryParam("paramName","paramValue")
// Add path parameters
            .addPathParam("paramName","paramValue")
// Build request specification
            .build();
}
