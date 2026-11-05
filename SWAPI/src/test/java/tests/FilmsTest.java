package tests;

import config.Specs;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("SWAPI")
@Feature("Films")
public class FilmsTest {

    @Test
    @Story("GET /films/1")
    @DisplayName("A New Hope — базовые поля")
    public void getFilm() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/films/1/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("title", equalTo("A New Hope"))
                .body("episode_id", equalTo(4))
                .body("director", equalTo("George Lucas"))
                .body("release_date", equalTo("1977-05-25"))
                .body("characters", hasItem("https://swapi.dev/api/people/1/"));
    }

    @Test
    @Story("GET /films/")
    @DisplayName("Всего 6+ фильмов")
    public void allFilms() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/films/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("count", greaterThanOrEqualTo(6));
    }
}
