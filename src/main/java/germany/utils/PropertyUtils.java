package germany.utils;

import germany.constants.FrameworkConstants;
import germany.enums.PropertiesType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public  final class PropertyUtils {

        private PropertyUtils() {}

    private static Properties properties =new Properties();
    private static Map<String,String> MAP =new HashMap<>();

static {
    try (FileInputStream inputStream =new FileInputStream(FrameworkConstants.PROPERTY_FILE_PATH)){
        properties.load(inputStream);//establishing the connection and loading the info
        }
    catch(IOException e){
        e.printStackTrace();
        System.exit(0);//incase the file is not found, the system should exit.
    }
    properties.entrySet().forEach(e->MAP.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
    //iterating the loaded entries and adding them into a map
}
public static String getValue(PropertiesType key){

    return MAP.get(key.name().toLowerCase()); //passing a key and getting the value from the map
}
}
