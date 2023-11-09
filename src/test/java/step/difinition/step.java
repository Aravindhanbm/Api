package step.difinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.IOException;

public class step extends RequestSpecfication{
    RequestSpecification res;
    ResponseSpecification respect;
    Response response;
     public static Logger loggerStep =Logger.getLogger(step.class);
    @Given("User set the baseurl for api")
    public void user_set_the_baseurl_for_api() throws PendingException {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


    }
    @Given("User set the payload and headers")
    public void user_set_the_payload_and_headers() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        res = RestAssured.given().spec(requestSpecification()).body(ApiPojo.requestBody);

    }
    @When("User execute post Request")
    public void user_execute_post_request() {
        // Write code here that turns the phrase above into concrete actions
        respect = new ResponseSpecBuilder().expectStatusCode(201)
                .expectContentType(ContentType.JSON).build();
        response = res.when().post("/posts").then().spec(respect).extract().response();

    }
    @Then("User validate the Response for api")
    public void user_validate_the_response_for_api() {
        // Write code here that turns the phrase above into concrete actions
            Assert.assertEquals(response.getStatusCode(),201);
        loggerStep.info("success");

    }
}
