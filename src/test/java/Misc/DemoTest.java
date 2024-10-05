package Misc;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class DemoTest {
   @Test
    public void test(){
        String payload ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
                RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/auth")
                        .contentType(ContentType.JSON)
                        .when().body(payload)
                        .then().log().all().statusCode(200);
    }
}
