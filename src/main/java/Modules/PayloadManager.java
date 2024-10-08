package Modules;

import Payloads.Request.Auth;
import Payloads.Request.Booking;
import Payloads.Request.BookingDates;
import Payloads.Response.AuthResponse;
import Payloads.Response.BookingResponse;
import Utils.FakerUtil;
import Utils.PropertyReaderyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;


public class PayloadManager {
    ObjectMapper ob = new ObjectMapper();

    @Test
    public String payload() throws JsonProcessingException {

        Booking booking = new Booking();
        booking.setFirstname("Aman");
       // booking.setFirstname(FakerUtil.getUsername());
        booking.setLastname("amn");
        booking.setTotalprice(550);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");

        BookingDates bd = new BookingDates();
        bd.setCheckin("2024-02-03");
        bd.setCheckout("2024-02-04");
        booking.setBookingdates(bd);

        String payloadb = ob.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println("the output is " + payloadb);
        return payloadb;
    }

    public BookingResponse jsonToObject(String jsonString) throws JsonProcessingException {
        BookingResponse bookingResponse = ob.readValue(jsonString, BookingResponse.class);
        return bookingResponse;
    }

    public String updatePayload() throws JsonProcessingException {

        Booking booking = new Booking();
        //booking.setFirstname("Aman");

        //we use the faker library to create fake data and with it code could not be hardcoded
        booking.setFirstname(FakerUtil.getUsername());
        booking.setLastname("amn");
        booking.setTotalprice(1000);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");
        BookingDates bd = new BookingDates();
        bd.setCheckin("2024-02-03");
        bd.setCheckout("2024-02-04");
        booking.setBookingdates(bd);

        String updatedPayload = ob.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(updatedPayload);
return updatedPayload;
    }
    @Test
    public Booking jsonToObj(String jsonString1) throws JsonProcessingException {
        Booking bookingResponse = ob.readValue(jsonString1, Booking.class);
        return bookingResponse;
    }

    @Test
    public String getAuthT() throws JsonProcessingException {

//Code to fetch data from data property file

//        String username;
//        String password;
//        try {
//            username = PropertyReaderyUtil.readKey("username");
//            password = PropertyReaderyUtil.readKey("password");
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to read username or password from properties file", e);
//        }
//        Auth auth = new Auth();
//        auth.setUsername(username);
//        auth.setPassword(password);
//        String data = ob.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
//        // System.out.println("token output is " + data);
//        return data;

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        String data = ob.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
        // System.out.println("token output is " + data);
        return data;
    }

    public AuthResponse jsonToObjectAuth(String jsonString) throws JsonProcessingException {
        AuthResponse autResponse = ob.readValue(jsonString, AuthResponse.class);
        return autResponse;
    }


}
