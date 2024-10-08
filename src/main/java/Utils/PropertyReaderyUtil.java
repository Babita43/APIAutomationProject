package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderyUtil
{
    public PropertyReaderyUtil(){

    }
public static  String readKey(String key) throws Exception {
    FileInputStream fileInputStream = new FileInputStream(new File((System.getProperty("user.dir")+ "/src/main/java/Resources/TestData.Properties")));
    Properties property = new Properties();
    property.load(fileInputStream );
    if (property.getProperty(key) == null) {
        throw new Exception("it is not found");
    }
        else{
return property.getProperty(key);
        }

    }

}

