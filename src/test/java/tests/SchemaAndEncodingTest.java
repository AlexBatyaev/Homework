package tests;

import config.Specs;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@Epic("SWAPI")
@Feature("Schema & Encodings")
public class SchemaAndEncodingTest {

    @Test
    @Story("JSON Schema")
    @DisplayName("/people/schema доступен")
    public void peopleSchema() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/people/schema/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("$", not(empty()));
    }

    @Test
    @Story("Wookiee")
    @DisplayName("?format=wookiee возвращает переведённые поля")
    public void wookieeFormat() {
        given()
                .spec(Specs.requestSpec())
                .queryParam("format", "wookiee")
                .when()
                .get("/planets/1/")
                .then()
                .spec(Specs.okResponseSpec())
                // в wookiee-формате поле "name" заменяется на "whrascwo"
                .body("whrascwo", equalTo("Tatooine"));
    }
}
