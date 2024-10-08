package crud;

import APIConstants.Base_URL;
import Base.BaseProg;
import Payloads.Request.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Integration extends BaseProg {
//Create booking, Update it, delete it and get it to check it is deleted or not
    String token;
    String bookingID;
public static final Logger log = LogManager.getLogger(Integration.class);
    @Test(groups = "p0")
    public void createBooking() throws JsonProcessingException {

        token = getToken();
        System.out.println("The token generated is :" + token);
        Booking booking = new Booking();


        requestSpecification.basePath(Base_URL.CREATE_URL);
        response = requestSpecification.when().body(payloadManager.payload()).post();
        bookingID = response.jsonPath().getString("bookingid");
        System.out.println("Booking id : " + bookingID);
        log.info("logs herr printing"+bookingID);
//        OR
//        BookingResponse br = payloadManager.jsonToObject(response.asString());
//        System.out.println("hrk:" + br.getBookingid().toString());
    }

    @Test(groups = "p0", dependsOnMethods = {"createBooking"})
    public void updateBooking() throws JsonProcessingException {
        Assert.assertEquals("hi", "hi");
        System.out.println("The token generated is :" + token);
        System.out.println("Booking id : " + bookingID);

        requestSpecification.basePath(Base_URL.UPDATE_URL + bookingID);
        response = requestSpecification.when().cookie("token",token).body(payloadManager.updatePayload()).put();
        System.out.println("Request URL: " + Base_URL.CREATE_URL + bookingID);

        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);

      Booking res= payloadManager.jsonToObj(response.asString());
        String pojo =res.getFirstname().toString();
        System.out.println("Updates output is :" +  pojo );

    }

   @Test(groups = "p0", dependsOnMethods = {"updateBooking","createBooking"})
    public void deleteBooking() throws JsonProcessingException {
        System.out.println("The token generated is :" + token);
        System.out.println("Booking id : " + bookingID);

        requestSpecification.basePath(Base_URL.UPDATE_URL + bookingID);
        response = requestSpecification.when().cookie("token",token).delete();
        System.out.println("Request URL: " + Base_URL.CREATE_URL + bookingID);

        validatableResponse =response.then();
        validatableResponse.statusCode(201);

    }

    @Test(groups = "p0", dependsOnMethods = {"updateBooking","createBooking","deleteBooking"})
    public void getBookingID() throws JsonProcessingException {
        System.out.println("The token generated is :" + token);
        System.out.println("Booking id : " + bookingID);

        requestSpecification.basePath(Base_URL.UPDATE_URL + bookingID);
        response = requestSpecification.when().cookie("token",token).get();
        System.out.println("Request URL: " + Base_URL.CREATE_URL + bookingID);

        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(404);

    }
}
