package base;

import io.cucumber.java.Before;
import static io.restassured.RestAssured.*;

public class Base {

    @Before
    public void setUp(){
        baseURI = "https://petstore.swagger.io";
        basePath = "/v2";
    }
}
