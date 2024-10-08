package Base;
import APIConstants.Base_URL;
import Actions.AssertVerify;
import Modules.PayloadManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BaseProg {
    public RequestSpecification requestSpecification=RestAssured.given();
    public JsonPath jsonPath;
    public Response response;
    public PayloadManager payloadManager;
    public AssertVerify actions;
    public ValidatableResponse validatableResponse;

    @BeforeMethod (alwaysRun = true)
        public void setUP(){
            payloadManager = new PayloadManager();  // Initialize payloadManager
            actions = new AssertVerify();  // Any other necessary initialization
            requestSpecification = RestAssured.given().contentType(ContentType.JSON).baseUri(Base_URL.BASE_URL);
        }
@Test
public String getToken() throws JsonProcessingException {
    // Any other necessary initialization
    String payload = payloadManager.getAuthT();
    requestSpecification = RestAssured.given().contentType(ContentType.JSON).baseUri(Base_URL.BASE_URL);
    response = requestSpecification.when().basePath(Base_URL.Auth_URL).body(payload).post();
    jsonPath = new JsonPath(response.asString());
    String token = jsonPath.getString("token");
   // System.out.println("the token is given :" + token);

    return token;
}

//       requestSpecification =new RequestSpecBuilder().setBaseUri(Base_URL.BASE_URL)
//               .addHeader("ContentType", "application/json")
//               .build().log().all();
        }



