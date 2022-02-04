package steps;

import base.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;


public class GetPetById implements Constantes {

    private Response response;
    private RequestSpecification request;

    @Given("user is the endpoint")
    public void user_is_the_endpoint() {
        request = given();


    }
    @When("do get with id {string}")
    public void do_get_with_id(String id) {
        response = request.when()
                .get(PATH_PET_ID, id)
                .then()
                .extract().response();
    }
    @Then("status code is {int}")
    public void status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());

    }
    @Then("show the description pet {string} {string} {string} {string}")
    public void show_the_description_pet(String nameCategory, String name, String id, String status) {
        Assert.assertEquals(nameCategory, response.jsonPath().get("category.name").toString());
        Assert.assertEquals(name, response.jsonPath().get("name").toString());
        Assert.assertEquals(id, response.jsonPath().get("id").toString());
        Assert.assertEquals(status, response.jsonPath().get("status").toString());
    }

    @Then("show a message {string}")
    public void show_a_message(String message) {
        Assert.assertEquals(message, response.jsonPath().get("message").toString());
    }


}
