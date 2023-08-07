package germany.utils;

import germany.constants.FrameworkConstants;
import germany.enums.PropertiesType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class JiraUtils {
    private JiraUtils() {
    }

public static String createIssueInJira(String errormessage, String stackTrace){

String body = ApiUtils.readJsonAndGetAsString(FrameworkConstants.REQUEST_JSON_FOLDER_PATH+"request1.json")
        .replace("KEY","KODE").replace("SUMMARY",errormessage).replace("DESCRIPTION", stackTrace);



        Response response= given()//.auth().basic("sumitbhatia0603","Antar101*")
                //RequestBuilder
                //.buildRequestForGetCalls()
                .body(body)
                .header("Authorization", "Basic c3VtaXRiaGF0aWEwNjAzOkFudGFyMTAxKg==")
                .header("Content-Type", "Application/JSON")
                .log().all()
                .post("http://127.0.0.1:8181/rest/api/2/issue/");

        response.prettyPrint();
        String jiraID= response.jsonPath().getString("key");//capturing the JIRA id for the issue raised from the response and return this to the method that calls the primary method of this class.
        given().header("Authorization", "Basic c3VtaXRiaGF0aWEwNjAzOkFudGFyMTAxKg==")
            .header("Content-Type", "Application/JSON")
                                      .post((PropertyUtils.getValue(PropertiesType.HOSTMACHINE)) +":8181/rest/api/3/issue/"+ jiraID+"/attachments");

    return jiraID;
    }


}
