package steps;

import base.Constantes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.JsonString;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AddANewPet implements Constantes {

    private Response response;
    private RequestSpecification request;
    private String json;
    private JsonString js;

    @Given("a user do in the endpoint")
    public void a_user_do_in_the_endpoint() {
        request = given();
    }

    @Given("with the datas {string} {string} {string} {string} {string} {string} {string}")
    public void with_the_datas(String idCategory, String nameCategory, String name, String photoUrls, String idTags, String nameTag, String status) {
        js = new JsonString();
        json = js.getJson(idCategory, nameCategory, name, photoUrls, idTags, nameTag, status);
        request = request.contentType(ContentType.JSON)
                .body(json);
    }

    @When("do post")
    public void do_post() {
        response = request.when()
                .post(PATH_PET)
                .then()
                .extract().response();
    }

    @Then("return status code {int}")
    public void return_status_code(int status) {
        Assert.assertEquals(status, response.getStatusCode());
    }

    @Then("show the body of the datas add {string} {string} {string} {string}")
    public void show_the_body_of_the_datas_add(String idCategory, String nameCategory, String name, String status) {
        Assert.assertEquals(idCategory, response.jsonPath().get("category.id").toString());
        Assert.assertEquals(nameCategory, response.jsonPath().get("category.name").toString());
        Assert.assertEquals(name, response.jsonPath().get("name").toString());
        Assert.assertEquals(status, response.jsonPath().get("status").toString());

    }

}
