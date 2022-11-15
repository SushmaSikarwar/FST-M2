package Project;

import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class ProviderTest {
    @BeforeEach
    void before(PactVerificationContext context) {
        // Set target for provider to send request to
        context.setTarget(new HttpTestTarget("localhost", 8585));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactTestTemplate(PactVerificationContext context) {
        // Verify the interaction between Consumer and Provider
        // using the contract generated in target/pacts
        context.verifyInteraction();
    }

    @State("A request to create a user")
    public void sampleState() {}

}