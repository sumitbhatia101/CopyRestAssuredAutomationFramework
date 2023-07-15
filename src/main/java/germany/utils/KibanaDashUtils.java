package germany.utils;

import germany.constants.FrameworkConstants;
import io.restassured.response.Response;
import org.testng.Assert;


import java.io.File;

import static io.restassured.RestAssured.given;

public class KibanaDashUtils {

    public static void setUpKibanaDash()

    {
        File file = new File(FrameworkConstants.KIBANA_SAVEDOBJECTS_FILEPATH + "exportSavedObjects.ndjson");

        Response response = given().log().all().header("Content-Type", "multipart/form-data").header("kbn-xsrf","true")
                .multiPart("file", file, "ndjson")
                .post("http://192.168.56.1:5601/api/saved_objects/_import?overwrite=true");

        Assert.assertEquals(response.statusCode(), 200);
        response.prettyPrint();
    }
}
