package tests;


import germany.annotations.FrameworkAnnotation;
import germany.reports.ExtentLogger;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthDemo {
    @Test
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void basicAuthTest(){
        Response response= given()
                //RequestBuilder
                //.buildRequestForGetCalls()

                //.auth().basic("postman","password")... less preferred as can onlu be used for basic auth.
                //a better way would be :
                .header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Content-Type")))// so that the password,Bearertoken etc are not logged.
                        .log().all()
                .get("https://postman-echo.com/basic-auth");
        response.prettyPrint();

       ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
         //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        /*assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(150);*/

        assertThat(response.getStatusCode()).isEqualTo(200);


    }

    @Test
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void bearerTokenAuth(){
        Response response= given()
                //RequestBuilder
                //.buildRequestForGetCalls()

                .header("X-API-Key", "PMAK-646ab0f0c2e2a3306f04d1bf-71dca0e76adc7075fb2748a102f5b792a5")
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Content-Type")))// so that the password,Bearertoken etc are not logged.
                .log().all()
                .get("https://api.getpostman.com/collections");
        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
        // ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        /*assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(150);*/

        assertThat(response.getStatusCode()).isEqualTo(200);


    }

    @Test
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void gitBearerToken(){
        Response response= given()
                //RequestBuilder
                //.buildRequestForGetCalls()

                .header("Authorization", "Bearer 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")
                .queryParam("sort ","created")
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Content-Type")))// so that the password,Bearertoken etc are not logged.
                .log().all()
                .get("https://api.github.com/user/repos");
        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
         //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        /*assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(150);*/

        assertThat(response.getStatusCode()).isEqualTo(200);


    }

    @Test
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void postGitBearerToken(){
        Response response= given()
                //RequestBuilder
                //.buildRequestForGetCalls()
                .body("{\"name\":\"Hello-Happen202\"}")
                .header("Authorization", "Bearer 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")
                //.header("Content-Type", "Application/JSON")
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Content-Type")))
                .log().all()
                .post("https://api.github.com/user/repos");

        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
         //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        /*assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(150);*/

        assertThat(response.getStatusCode()).isEqualTo(201);


    }



    @Test(description = "to check something")
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void postCreatingIssueJira(){
        Response response= given()//.auth().basic("sumitbhatia0603","Antar101*")
                //RequestBuilder
                //.buildRequestForGetCalls()
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\":\n" +
                        "       {\n" +
                        "          \"key\": \"KODE\"\n" +
                        "       },\n" +
                        "       \"summary\": \"KodeKüche ist wunderbar.\",\n" +
                        "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}")
                .header("Authorization", "Basic c3VtaXRiaGF0aWEwNjAzOkFudGFyMTAxKg==")
                .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization", "Content-Type")))// so that the password,Bearertoken etc are not logged.
                .header("Content-Type", "Application/JSON")
                .log().all()
                .post("http://192.168.56.1:8181/rest/api/2/issue/");

        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
        //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        /*assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(150);*/

        assertThat(response.getStatusCode()).isEqualTo(207);


    }
}
