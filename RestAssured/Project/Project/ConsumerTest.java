package Project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;


@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    Map<String, String> headers = new HashMap<>();

    String resoursePath = "/api/users";

    // Create Pact contract
    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder)  {
        // Add headers
        headers.put("Content-Type", "application/json");
     //   headers.put("Accept", "application/json");

        // Create request JSON Body
        DslPart bodySentCreateUser = new PactDslJsonBody()
                .numberType("id", 373)
                .stringType("firstName", "Sushma")
                .stringType("lastName", "Sikarwar")
                .stringType("email", "sush.sika@testmail.com");

        DslPart bodyReceivedCreateUser = new PactDslJsonBody()
                .numberType("id", 373)
                .stringType("firstName", "Sushma")
                .stringType("lastName", "Sikarwar")
                .stringType("email", "sush.sika@testmail.com");

        // Create rules for request and response (Interaction to Pact)
        return builder.given("A request to create a user")
                .uponReceiving("A request to create a user")
                .path(resoursePath)
                .method("POST")
                .headers(headers)
                .body(bodySentCreateUser)
                .willRespondWith()
                .status(201)
                .body(bodyReceivedCreateUser)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8080")
    public void runTest() {

        // Mock url
       String baseURI = "http://localhost:8080" + resoursePath;
        // Create request specification
        RequestSpecification rq =
                RestAssured.given().headers(headers).when();

        Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", 373);
                map.put("firstName", "Sushma");
                map.put("lastName", "Sikarwar");
                map.put("email", "sush.sika@testmail.com");

        // Send POST request
        Response response = rq.body(map).post(baseURI);
        // Assertion
        assert (response.getStatusCode() == 201);

    }

}


