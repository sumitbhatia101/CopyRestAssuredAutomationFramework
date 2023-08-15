package germany.constants;

public class FrameworkConstants {
    private FrameworkConstants() {
    }
    //if there are static methods in a class, the @Getter/@setter annotation would not work at class level, they have to be part of the signatures :
    //private static @Getter final String requestJsonFolderPath = System.getProperty("user.dir")+ "/src/test/resources/request.json/request.json";
    //private static @Getter final String responseJsonFolderPath = System.getProperty("user.dir")+ "/output/";
    // The above(private methods with Getters) is only if there is a specific requirement to restrict access to framework constants

    public   static final String REQUEST_JSON_FOLDER_PATH = System.getProperty("user.dir")+ "/src/test/resources/jsons/";
    public static final String RESPONSE_JSON_FOLDER_PATH = System.getProperty("user.dir")+ "/output/";

    public static final String PROPERTY_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/config.properties/";

    public static final String KIBANA_SAVEDOBJECTS_FILEPATH = System.getProperty("user.dir")+ "/src/test/resources/jsons/";

}
