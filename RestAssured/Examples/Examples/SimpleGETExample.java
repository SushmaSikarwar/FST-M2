package Examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class SimpleGETExample {

    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    public void modifyPetInfo(){

        Response response = given().contentType(ContentType.JSON).when().get(BASE_URI + "/77232");

        System.out.println(response.asPrettyString());
        response.then().body("status", equalTo("alive"));
        response.then().body("name", equalTo("Teddy"));
        response.then().time(lessThan(5000l));
        response.then().statusCode(200);
    }
}