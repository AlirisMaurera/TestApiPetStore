package utils;

import base.Constantes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Funtions implements Constantes {

    public Response doPost(String json){
        Response response;
        response = given().contentType(ContentType.JSON).body(json).when().post(PATH_PET).then().extract().response();
        return response;
    }
}
