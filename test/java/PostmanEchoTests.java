import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class PostmanEchoTests {

    private static final Logger logger = LoggerFactory.getLogger(PostmanEchoTests.class);

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
        logger.info("Настройка базового URI: {}", RestAssured.baseURI);
    }

    @Test
    void getExampleTest() {
        logger.info("Начало теста GET запроса");
        Response response = given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        logger.info("GET запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");

        // Проверка тела ответа
        String url = response.jsonPath().getString("url");
        logger.info("URL из тела ответа: {}", url);
        assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", url, "URL не совпадает");
        logger.info("Тест GET запроса успешно завершен");
    }

    @Test
    void postExampleTest() throws IOException {
        logger.info("Начало теста POST запроса");
        String requestBody = new String(Files.readAllBytes(Paths.get("src/test/resources/example_post_body.json")));

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        logger.info("POST запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");

        // Проверка тела ответа
        String json = response.jsonPath().getString("json");
        logger.info("JSON из тела ответа: {}", json);
        assertEquals(requestBody.replaceAll("\\s+", ""), json.replaceAll("\\s+", ""), "Тело ответа не совпадает");
        logger.info("Тест POST запроса успешно завершен");
    }

    @Test
    void putExampleTest() {
        logger.info("Начало теста PUT запроса");
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("foo", "bar");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        logger.info("PUT запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");

        // Проверка тела ответа
        String data = response.jsonPath().getString("json.foo");
        logger.info("Данные из тела ответа: {}", data);
        assertEquals("bar", data, "Данные в теле ответа не совпадают");
        logger.info("Тест PUT запроса успешно завершен");
    }

    @Test
    void deleteExampleTest() {
        logger.info("Начало теста DELETE запроса");
        Response response = given()
                .when()
                .delete("/delete")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        logger.info("DELETE запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");

        // Проверка тела ответа
        String url = response.jsonPath().getString("url");
        logger.info("URL из тела ответа: {}", url);
        assertEquals("https://postman-echo.com/delete", url, "URL не совпадает");
        logger.info("Тест DELETE запроса успешно завершен");
    }

    @Test
    void statusCodesExampleTest() {
        logger.info("Начало теста проверки статус кодов");
        Response response = given()
                .when()
                .get("/status/200")
                .then()
                .extract()
                .response();

        logger.info("Запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");
        logger.info("Тест проверки статус кодов успешно завершен");
    }

    @Test
    void requestHeadersExampleTest() {
        logger.info("Начало теста проверки заголовков запроса");
        Response response = given()
                .header("My-Sample-Header", "Test Value")
                .when()
                .get("/headers")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        logger.info("Запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");

        // Проверка тела ответа (наличие заголовка)
        String headerValue = response.jsonPath().getString("headers.'My-Sample-Header'");
        logger.info("Значение заголовка: {}", headerValue);
        assertEquals("Test Value", headerValue, "Значение заголовка не совпадает");
        logger.info("Тест проверки заголовков запроса успешно завершен");
    }

    @Test
    void responseHeadersExampleTest() {
        logger.info("Начало теста проверки заголовков ответа");
        Response response = given()
                .when()
                .get("/response-headers?Content-Type=application/json&Custom-Header=CustomValue")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        logger.info("Запрос выполнен, код ответа: {}", response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Код ответа должен быть 200");

        // Проверка содержания заголовка Content-Type
        String contentType = response.getHeader("Content-Type");
        logger.info("Значение Content-Type: {}", contentType);
        assertTrue(contentType.contains("application/json"), "Content-Type должен содержать application/json");

        // Проверка наличия и значения кастомного заголовка
        String customHeader = response.getHeader("Custom-Header");
        logger.info("Значение Custom-Header: {}", customHeader);
        assertEquals("CustomValue", customHeader, "Custom-Header должен быть равен CustomValue");
        logger.info("Тест проверки заголовков ответа успешно завершен");
    }
}
