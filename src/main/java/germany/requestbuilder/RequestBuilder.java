package germany.requestbuilder;

import germany.enums.PropertiesType;
import germany.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestBuilder {
    private RequestBuilder(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .log()
                .all();
                //.header("Content-Type", "Application/JSON");
                //.contentType(ContentType.JSON);

    }
    public static RequestSpecification buildRequestForPostCalls() {
        return buildRequestForGetCalls()
                .contentType(ContentType.JSON);
                //.header("Content-Type", "Application/JSON")// same as content type



    }
}
