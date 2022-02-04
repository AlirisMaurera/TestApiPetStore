package steps;

import base.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.Funtions;
import utils.JsonString;

import static io.restassured.RestAssured.*;


public class DeleteAPet implements Constantes{

    private Response response;
    private Response responseId;
    private RequestSpecification request;
    private JsonString json;
    private Funtions funtions;
    private String Id;

    @Given("a user is in the endpoint with pet add {string} {string} {string} {string} {string} {string} {string}")
    public void a_user_is_in_the_endpoint_with_pet_add(String idCategory, String nameCategory, String name, String photoUrls, String idTags, String nameTag, String status) {
        json = new JsonString();
        funtions = new Funtions();
        String js = json.getJson(idCategory, nameCategory, name, photoUrls, idTags, nameTag, status);
        responseId = funtions.doPost(js);
        Id = responseId.jsonPath().get("id").toString();

        request = given();


    }

    @When("do delete with id")
    public void do_put_with_id() {
        response = request.delete(PATH_PET_ID, Id).then().extract().response();

    }
    @Then("status code {int}")
    public void status_code(int status) {
        Assert.assertEquals(status, response.getStatusCode());
    }

    @Given("user is in the endpoint")
    public void user_is_in_the_endpoint() {
        request = given();
    }

    @When("do delete with {string}")
    public void do_delete_with(String id) {
        response = request.delete(PATH_PET_ID, id).then().extract().response();
    }



}
