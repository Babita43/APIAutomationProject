package crud;


import APIConstants.Base_URL;
import Base.BaseProg;
import Payloads.Response.BookingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateBooking extends BaseProg {
    @Test(groups = {"p0"})
    @Owner("Babita")
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify the create booking code")
    public void testCreateBooking() throws JsonProcessingException {
        //Call the request block
        // call the payload
        // call the assertion

        requestSpecification.basePath(Base_URL.CREATE_URL);
        response = requestSpecification.when().body(payloadManager.payload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
      //  new YamlReader().readKey().get("username");

        BookingResponse bookingResponse = payloadManager.jsonToObject(response.asString());
        Integer bookingId = bookingResponse.getBookingid();  // Assuming getBookingid() returns the ID
        System.out.println("Booking ID: " + bookingId);  // Print the booking ID
        assertThat(bookingResponse.getBookingid()).isNotNull();  // Additional assertions if necessary

    }
}
