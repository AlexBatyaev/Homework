import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com";
    private final int EXPECTED_STATUS_CODE = 200; // Set Your expected status code;

    @Test
    public void testGetRequestWithQueryParams() {
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();


    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .baseUri(BASE_URL)
                .body(requestBody)
                .post("/post")
                .then()
                .statusCode(EXPECTED_STATUS_CODE) // Check Status code
                .extract()
                .response();

    }

    @Test
    public void testPostEmptyBody() {
        Response response = given()
                .baseUri(BASE_URL)
                .post("/post")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();

    }

    @Test
    public void testPutRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .baseUri(BASE_URL)
                .body(requestBody)
                .put("/put")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testPatchRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .baseUri(BASE_URL)
                .body(requestBody)
                .patch("/patch")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testDeleteRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .baseUri(BASE_URL)
                .body(requestBody)
                .delete("/delete")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetRequestWithHeaders() {
        Response response = given()
                .baseUri(BASE_URL)
                .header("my-sample-header", "Lorem ipsum dolor sit amet")
                .get("/headers")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetRequestWithResponseHeaders() {
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/response-headers")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testBasicAuth() {
        Response response = given()
                .baseUri(BASE_URL)
                .auth().basic("postman", "password")
                .get("/basic-auth")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetCookiesSet() {
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/cookies/set")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();

        //Verify cookies - I would create method for extraction of cookies

    }

    @Test
    public void testGetCookies(){
        Response response = given()
                .baseUri(BASE_URL)
                .get("/cookies")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();

        //Get Cookies
    }

    @Test
    public void testDeleteCookies(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("foo1", "null")
                .queryParam("foo2", "null")
                .get("/cookies/delete")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();

        //Verify Cookies are deleted
    }

    @Test
    public void testGetStatus(){
        Response response = given()
                .baseUri(BASE_URL)
                .get("/status/200")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }


    @Test
    public void testGetEncodingUTF8(){
        Response response = given()
                .baseUri(BASE_URL)
                .get("/encoding/utf8")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetGzip(){
        Response response = given()
                .baseUri(BASE_URL)
                .header("Accept-Encoding", "gzip, deflate, br") //Explicitly adding gzip
                .get("/gzip")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetDeflate(){
        Response response = given()
                .baseUri(BASE_URL)
                .header("Accept-Encoding", "gzip, deflate, br") //Explicitly adding deflate
                .get("/deflate")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetIP(){
        Response response = given()
                .baseUri(BASE_URL)
                .get("/ip")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeNow(){
        Response response = given()
                .baseUri(BASE_URL)
                .get("/time/now")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeVaid(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .get("/time/valid")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }


    @Test
    public void testGetTimeFormat(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("format", "mm")
                .get("/time/format")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeUnit(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("unit", "day")
                .get("/time/unit")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeAdd(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("years", "100")
                .get("/time/add")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeSubtract(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("years", "50")
                .get("/time/subtract")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeStart(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("unit", "month")
                .get("/time/start")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeOBject(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .get("/time/object")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeBefore(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("target", "2017-10-10")
                .get("/time/before")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeAfter(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("target", "2017-10-10")
                .get("/time/after")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }

    @Test
    public void testGetTimeBetween(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .queryParam("start", "2017-10-10")
                .queryParam("end", "2019-10-10")
                .get("/time/between")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }


    @Test
    public void testGetTimeLeap(){
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("timestamp", "2016-10-10")
                .get("/time/leap")
                .then()
                .statusCode(EXPECTED_STATUS_CODE)
                .extract()
                .response();
    }
   }
