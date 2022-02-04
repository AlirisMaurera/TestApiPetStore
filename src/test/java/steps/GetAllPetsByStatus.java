package steps;

import base.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class GetAllPetsByStatus implements Constantes{

    private Response response;
    private RequestSpecification request;

    @Given("a user is in the endpoint")
    public void a_user_is_in_the_endpoint() {
      request = given();
    }
    @When("do get with status of the pet {string}")
    public void do_get(String status) {
        response = when().get(PATH_PET_STATUS, status)
                .then()
                .extract().response();
    }
    @Then("status code return is {int}")
    public void status_code_return_is(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }
    @Then("show all pets with status {string}")
    public void show_all_pets_with_status(String status) {
        System.out.println(response.jsonPath().getList("status").toString());
        Assert.assertTrue(response.jsonPath().getList("status").toString().contains(status));
    }


}
