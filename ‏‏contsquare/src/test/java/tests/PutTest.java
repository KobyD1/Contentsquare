package tests;

import infra.Movie;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PutTest extends TestBase {


    @Test(description = "Update movie with default values - Funcional test")
    public void updateMovie() {
        String id = "3";

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(defaultMovieObj)
                .when()
                .put(id)
                .then()
                .statusCode(200);
        apiClient.compareRespBodyByGet(id, defaultMovieObj);

    }

    @Test(description = "Update not exist movie")
    public void updateNotExistMovie() {
        String id = utils.getRandomInteger(10,50)+"";
        apiClient.prepareMovieByDelete(id);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(defaultMovieObj)
                .when()
                .put(id)
                .then()
                .statusCode(200);

    }

    @Test(description = "Update movie with not default values")
    public void updateMovieNotDefaultValues() {
        String id = "3";
        Integer randomYear = utils.getRandomInteger(1950, 2030);
        Movie MovieObj = new Movie(randomYear, "D1!@#$%^&", null);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(MovieObj)
                .when()
                .put(id)
                .then()
                .statusCode(200);
        apiClient.compareRespBodyByGet(id, MovieObj);

    }


}
