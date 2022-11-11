package Examples;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    // Set the base URI
    String baseURI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void getRequestWithQueryParams(){

        Response response =
                given().header("Content-Type", "application/json").queryParam("status", "sold")
                        .when().get(baseURI + "/findByStatus");

        System.out.println(response.getBody().asString());

        System.out.println(response.getHeaders().asList());

        String petStatus = response.then().extract().path("[0].status");
        System.out.println(petStatus);

        assertEquals(petStatus,"sold");
        response.then().statusCode(200).body("[0].status", equalTo("sold"));
        response.then().time(lessThan(2000l));

    }
    @Test
    public void getRequestWithPathParams(){

        given().header("Content-Type", "application/json").pathParam("petId", 9)
                        .when().get(baseURI + "/{petId}")
                        .then().statusCode(200).body("status",equalTo("sold")).time(lessThan(2000l));

    }

    @Test
    public void getPetDetails() {
        // Specify the base URL to the RESTful web service
       // String baseURI = "https://petstore.swagger.io/v2/pet";

        // Make a request to the server by specifying the method Type and
        // resource to send the request to.
        // Store the response received from the server for later use.
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

        // Now let us print the body of the message to see what response
        // we have received from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));
    }

}