package tests;

import config.Specs;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("SWAPI")
@Feature("Starships, Vehicles, Species")
public class MiscResourcesTest {

    @Test
    @Story("Starships")
    @DisplayName("Death Star — характеристики")
    public void getDeathStar() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/starships/9/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("name", equalTo("Death Star"))
                .body("model", equalTo("DS-1 Orbital Battle Station"))
                .body("starship_class", notNullValue());
    }

    @Test
    @Story("Vehicles")
    @DisplayName("Sand Crawler — характеристики")
    public void getSandCrawler() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/vehicles/4/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("name", equalTo("Sand Crawler"))
                .body("vehicle_class", equalTo("wheeled"));
    }

    @Test
    @Story("Species")
    @DisplayName("Wookiee — данные вида")
    public void getWookiee() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/species/3/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("name", equalTo("Wookiee"))
                .body("language", equalTo("Shyriiwook"))
                .body("people", hasItem("https://swapi.dev/api/people/13/"));
    }
}
