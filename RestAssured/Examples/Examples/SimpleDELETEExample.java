package Examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SimpleDELETEExample {

    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    public void deletePet(){

        Response response = given().contentType(ContentType.JSON)
                .when().delete(BASE_URI);

       String resBody = response.getBody().asPrettyString();
       System.out.println(resBody);


       response = given().contentType(ContentType.JSON).when().get(BASE_URI + "/77232");

       System.out.println(response.getBody().asPrettyString());

        response.then().statusCode(404);
        response.then().body("message", equalTo("Pet Not Found"));
    }
}
