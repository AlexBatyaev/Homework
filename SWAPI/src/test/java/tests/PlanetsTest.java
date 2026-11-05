package tests;

import config.Specs;
import io.qameta.allure.*;
import models.Planet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("SWAPI")
@Feature("Planets")
public class PlanetsTest {

    @Test
    @Story("GET /planets/1")
    @DisplayName("Tatooine — данные планеты")
    public void getTatooine() {
        Planet planet = given()
                .spec(Specs.requestSpec())
                .when()
                .get("/planets/1/")
                .then()
                .spec(Specs.okResponseSpec())
                .extract()
                .as(Planet.class);

        assertEquals("Tatooine", planet.getName());
        assertEquals("Arid", planet.getClimate());
        assertEquals("10465", planet.getDiameter());
        assertEquals("https://swapi.dev/api/planets/1/", planet.getUrl());
        assertFalse(planet.getResidents().isEmpty());
        assertTrue(planet.getResidents().contains("https://swapi.dev/api/people/1/"));
    }

    @Test
    @Story("Search")
    @DisplayName("Поиск по 'tatoo' находит Tatooine")
    public void searchTatooine() {
        given()
                .spec(Specs.requestSpec())
                .queryParam("search", "tatoo")
                .when()
                .get("/planets/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("count", greaterThan(0))
                .body("results.name", hasItem("Tatooine"));
    }
}