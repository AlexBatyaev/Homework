package tests;

import models.SearchResult;
import config.Specs;
import io.qameta.allure.*;
import models.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("SWAPI")
@Feature("People")
public class PeopleTest {

    @Test
    @Story("GET /people/1")
    @DisplayName("Luke Skywalker — проверка полей")
    public void getLukeSkywalker() {
        Person person = given()
                .spec(Specs.requestSpec())
                .when()
                .get("/people/1/")
                .then()
                .spec(Specs.okResponseSpec())
                .extract()
                .as(Person.class);

        assertEquals("Luke Skywalker", person.getName());
        assertEquals("https://swapi.dev/api/planets/1/", person.getHomeworld());
        assertEquals("https://swapi.dev/api/people/1/", person.getUrl());
        assertFalse(person.getFilms().isEmpty());
    }

    @Test
    @Story("GET /people/")
    @DisplayName("Список людей содержит count и results")
    public void getAllPeople() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/people/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("count", greaterThan(0))
                .body("results", not(empty()))
                .body("results[0].name", notNullValue());
    }

    @Test
    @Story("Search")
    @DisplayName("Поиск по 'r2' возвращает R2-D2")
    public void searchR2() {
        SearchResult<Person> result = given()
                .spec(Specs.requestSpec())
                .queryParam("search", "r2")
                .when()
                .get("/people/")
                .then()
                .spec(Specs.okResponseSpec())
                .extract()
                .as(new io.restassured.common.mapper.TypeRef<SearchResult<Person>>() {});

        assertTrue(result.getCount() >= 1);
        assertTrue(result.getResults().stream()
                .anyMatch(p -> p.getName().contains("R2-D2")));
    }

    @ParameterizedTest(name = "ID={0} — 200 OK")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Story("GET /people/{id}")
    public void peopleIdsAreValid(int id) {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/people/" + id + "/")
                .then()
                .spec(Specs.okResponseSpec())
                .body("name", notNullValue())
                .body("url", containsString("/people/" + id + "/"));
    }

    @Test
    @Story("GET /people/9999")
    @DisplayName("Несуществующий ID возвращает 404")
    public void notFoundPerson() {
        given()
                .spec(Specs.requestSpec())
                .when()
                .get("/people/9999/")
                .then()
                .statusCode(404);
    }
}
