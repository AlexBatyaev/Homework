package tests;

import models.Root;
import config.Specs;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("SWAPI")
@Feature("Root")
public class RootTest {

    @Test
    @Story("GET /")
    @DisplayName("Root возвращает ссылки на все ресурсы")
    public void rootReturnsAllResources() {
        Root root = given()
                .spec(Specs.requestSpec())
                .when()
                .get("/")
                .then()
                .spec(Specs.okResponseSpec())
                .extract()
                .as(Root.class);

        assertEquals("https://swapi.dev/api/films/", root.getFilms());
        assertEquals("https://swapi.dev/api/people/", root.getPeople());
        assertEquals("https://swapi.dev/api/planets/", root.getPlanets());
        assertEquals("https://swapi.dev/api/species/", root.getSpecies());
        assertEquals("https://swapi.dev/api/starships/", root.getStarships());
        assertEquals("https://swapi.dev/api/vehicles/", root.getVehicles());
    }
}
