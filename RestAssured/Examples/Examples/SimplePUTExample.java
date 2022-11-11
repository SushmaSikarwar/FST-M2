package Examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SimplePUTExample {

    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    public void modifyPetInfo(){

        String reqBody = "{\"id\" : 77232  \"name\" : \"Kalli\" , \"status\" : \"alive\"}";

        Response response = given().contentType(ContentType.JSON).body(reqBody).when().put(BASE_URI);

        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);

        response.then().body("name", equalTo("Kalli"));
    }
}
