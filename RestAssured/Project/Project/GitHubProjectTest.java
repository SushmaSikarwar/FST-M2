package Project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.CoreMatchers.equalTo;

public class GitHubProjectTest {

    RequestSpecification requestSpec;

    String sshKey;
    int sshKeyID;

    @BeforeClass
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                    // Set content type
                .setContentType(ContentType.JSON)
                    // SetAuth (auth2("ghp_"))
               // .setAuth(oauth2("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"))
               .addHeader("Authorization", "Project_Token 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")
                    // Set base URL
                .setBaseUri("https://api.github.com")
                    // Build request specification
                .build();
    }


    @Test(priority=1)
    public void addSSHKey() {

        Map<String, Object> reqBody = new HashMap<>();

        reqBody.put("title","TestAPIKey");
        reqBody.put("key", "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDY5whAsUQWVBO+QjGJdztfro2tVJMdGB1jyOi9JzLNofD4hVD9paPxzgM99/mnvmakxjyD94ciXUsOLFrGqUhcpaAbVkz5CHOijVLoXoigxrAyLkCzR94k8EtrWoBOmhlq+jLjmZlWAWRjBIVp6Zrsdu4aTdhjcoIJvVrNkePcvQtBXrjXB+U7fYIaEM5mxF7KUbNJ6ExM81ldBrRgloNhguWcrcvZB9aK59+/mDgRxyoqekqQ7M+pYVvaHPr4zB6jIQlP99vXMI3vpRaSUoB+nev/giz+pqy36TxP0oA2iIAa9YB68GD7HV18yCm01peCj6NEiRdq8EGJoii/X2gv");

        Response response = given().contentType(ContentType.JSON)
                .body(reqBody)
                .when().post("https://api.github.com/user/keys");

        String body = response.getBody().asPrettyString();
        System.out.println(body);

        //sshKeyID = response.then().extract().path("id");
      //  System.out.println(sshKeyID);

        response.then().statusCode(200);
    }


    @Test(priority=2)
    public void getSSHKey() {

        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("keyId", sshKeyID) // Set path parameter
                        .get("https://api.github.com/user/keys/{keyId}"); // Send GET request

        System.out.println(response);

        response.then().statusCode(201);
    }

    @Test(priority=3)
    public void deleteSSHKey() {

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("keyId", sshKeyID)// Set path parameter
                        .delete("https://api.github.com/user/keys/{keyId}"); // Send DELETE request

        System.out.println(response);

        response.then().statusCode(204);
    }

}
