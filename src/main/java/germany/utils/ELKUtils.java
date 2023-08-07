package germany.utils;


import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;


public final class ELKUtils {
    private ELKUtils() {}

    public static void sendDetailsToElk(String testname, String status) {

        Map<String, String> map = new HashMap<>();

        map.put("testName", testname );
        map.put("status", status);
        map.put("executionTime", LocalDateTime.now().toString());

        Response response = given().header("Content-Type", "application/json")
                .log().all()
                .body(map)
                .post(LocalIPutils.getLocalIPAddress() +":9200/smoke/results");

        Assert.assertEquals(response.statusCode(), 201);


        response.prettyPrint();
    }
}
