package api;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServiceTest {

    @Test
    public void check200()
    {
        given().when().
                get("https://www.gov.uk")
                .then().
                statusCode(300);

    }

    @Test
    public void checkResponseBody()
    {

        String responseBody = given().when().
                get("https://data.fixer.io/api/latest")
                .then().extract().response().asString();
        String success = JsonPath.read(responseBody,"$.success").toString();

        System.out.println(responseBody);
        System.out.println(success);

    }



}
