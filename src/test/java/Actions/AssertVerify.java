package Actions;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertVerify {

    public void verifyStatusCode(Response response){
        Assert.assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"),
                "The value of the status code is: " + response.getStatusCode());
    }

    public void verifyResponseBody(String actual, String expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyResponseBody( int actual, int expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyResponseBody(double actual, double expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
}
