package Examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SimplePOSTExample {

    final static String BASE_URI = "https://petstore.swagger.io/v2/pet";

    public void addNewPet(){

        Map<String, Object> reqBody = new HashMap<>();

        reqBody.put("id",77232);
        reqBody.put("name","Teddy");
        reqBody.put("status","alive");


        Response response = given().contentType(ContentType.JSON)
                .body(reqBody)
                .when().post(BASE_URI);

        String body = response.getBody().asPrettyString();
        System.out.println(body);

        response.then().statusCode(200);
        response.then().body("name", equalTo("Teddy"));
    }
}
