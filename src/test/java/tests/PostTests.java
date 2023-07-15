package tests;

import germany.annotations.FrameworkAnnotation;
import germany.constants.FrameworkConstants;
import germany.pojo.Employee;
import germany.reports.ExtentLogger;
import germany.requestbuilder.RequestBuilder;
import germany.utils.ApiUtils;
import germany.utils.RandomUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTests extends BaseTest {
    @Test
    @FrameworkAnnotation(authors = {"Amuthan", "Sumit"}, categories = {"Regression", "Smoke"})
    public void postCallTestPojo() {

        Employee employee = Employee
                .builder()
                .setId(RandomUtils.getId())
                .setFname(RandomUtils.getFirstName())
                .setLname(RandomUtils.getLastName())
                .setEmail(RandomUtils.getEmail())
                .build();


        System.out.println(employee.toString());
        Response response = RequestBuilder
                .buildRequestForPostCalls()
                .body(employee)
                .post("/users");
        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
        // ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        assertThat(response.getStatusCode()).isEqualTo(201);

        /*assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(144);*/


        //assertThat(response.jsonPath().getString("email")), "jaymie.collier@gmail.com");


    }

    @Test
    @FrameworkAnnotation(authors = {"Amuthan", "Sumit"}, categories = {"Regression", "Smoke"})
    public void postRequestUsingExternalFile(Method method) {
        /*Method is a reflection class and method.getName() would pass the name of the
        Test method to create the response file with filename same as method name*/

        String resource = ApiUtils
                .readJsonAndGetAsString(FrameworkConstants.REQUEST_JSON_FOLDER_PATH + "request.json")
                .replace("fname", RandomUtils.getFirstName())
                .replace("number", String.valueOf(RandomUtils.getId()));

        Response response = RequestBuilder
                .buildRequestForPostCalls()
                .body(resource)
                .post("/users");
        response.prettyPrint();

        /*the ONLY objective of the following line of code is to format
        the response to json and show it on the extent report.*/
        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the extent logger method which will further call
         //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        ApiUtils.storeStringAsJsonFile(FrameworkConstants.RESPONSE_JSON_FOLDER_PATH + method.getName() + "response.json", response);

        assertThat(response.getStatusCode()).isEqualTo(201);
    }
    
    /*

    public void shitReflections(Method method){
        System.out.println(method);
    }

    /*
    public void getEmployeeDetail(){
        Response response= RequestBuilder
                .buildRequestForPostCalls()
                .pathParam("id", 350)
                .get("/users/{id}");
        response.prettyPrint();

        assertThat(response.jsonPath().getMap("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(50);

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("lastname")).isEqualTo("chappu");


    }*/

}
