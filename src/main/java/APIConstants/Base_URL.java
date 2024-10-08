package APIConstants;

import Utils.PropertyReaderyUtil;

public class Base_URL {

//   public static  String BASE_URL = "https://restful-booker.herokuapp.com";
//   public static  String CREATE_URL = "/booking";
//   public static  String UPDATE_URL = "/booking/";
//   public static String Auth_URL = "/auth";

    //OR  we can use fillo to make the data not hardcoded the above makes code hard coded

    public static String BASE_URL;
   public static String CREATE_URL;
   public static  String UPDATE_URL;
   public static String Auth_URL;
    static {
        try {
            BASE_URL = PropertyReaderyUtil.readKey("url");
            CREATE_URL = PropertyReaderyUtil.readKey("CREATE_URL");
            UPDATE_URL = PropertyReaderyUtil.readKey("UPDATE_URL");
            Auth_URL = PropertyReaderyUtil.readKey("Auth_URL");
        } catch (Exception e) {
           // log.error("Error reading base URL from properties", e);
            throw new RuntimeException("Failed to initialize BASE_URL", e);
        }
    }

}
