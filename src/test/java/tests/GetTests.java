package tests;



import germany.annotations.FrameworkAnnotation;
import germany.reports.ExtentLogger;
import germany.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetTests extends BaseTest{
    @Test
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void getEmployeeDetails(){
       Response response= RequestBuilder
                .buildRequestForGetCalls()
                .get("/users");
        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
        //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/



        assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("validating size of the array")
                .isLessThan(1000);

        assertThat(response.getStatusCode()).isEqualTo(200);


    }
    @Test
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void getEmployeeDetail(){
        Response response= RequestBuilder
                .buildRequestForGetCalls()
                .pathParam("id", 3032)
                .get("/users/{id}");
        response.prettyPrint();


        //ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
         //ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/


        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("last_name")).isEqualTo("Rivera");


    }
    @Test(dataProvider = "getData")
    @FrameworkAnnotation(authors = {"Amuthan","Sumit"}, categories = {"Regression", "Smoke"})
    public void getEmployeeDetailDataProvider(Integer id, String lastname){
        //ExtentManager.getTest().assignAuthor("Sumit").assignCategory("Smoke");//Incase these fields are required in the extent report

        Response response= RequestBuilder
                .buildRequestForGetCalls()
                .pathParam("id", id)
                .get("/users/{id}");
        response.prettyPrint();

        ExtentLogger.logResponse(response.prettyPrint()); /*this will call the event logger method which will further call
         ExtentManager.getTest()---> which finaly reaches getter and setter for ExtentReport class ,all for the extent report*/

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("last_name")).isEqualTo(lastname);


    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {3030, "Rodriguez"},
                {3031, "Bailey"},
                {3032, "Rivera"},};

    }
}
