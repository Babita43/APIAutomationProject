package Utils;

import com.github.javafaker.Faker;

public class FakerUtil {
   public static Faker faker= new Faker();

    public static String getUsername(){

        String name = faker.name().firstName();
        return name;
    }

}
