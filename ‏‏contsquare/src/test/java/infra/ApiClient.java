package infra;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ApiClient {

    public void prepareMovieByUpdate(String id, Movie movie) {
        System.out.println("Try to prepare movie by update , ID=" + id);

        RestAssured.given()
                .body(movie)
                .contentType(ContentType.JSON)
                .put(id)
                .then()
                .statusCode(200);

    }

    public void prepareMovieByDelete(String id) {
        System.out.println("Try to prepare move by delete, ID=" + id);

        RestAssured.given()
                .when()
                .delete(id)
                .then()
                .statusCode(200);

    }

    public void prepareEnvByReset() {
        System.out.println("Try to Reset enviroment");

        RestAssured.given()
                .when()
                .get("/reset")
                .then()
                .statusCode(200);
    }


    public void compareRespCodeByGet(String id, Integer expResponseCode) {
        System.out.println("Verify response code by get , ID=" + id);

        RestAssured.given()
                .when()
                .get(id)
                .then()
                .statusCode(expResponseCode);
    }

    public void compareRespBodyByGet(String id, Movie expMovie) {
        System.out.println("Verify response body by get , ID=" + id);

        RestAssured.given()
                .when()
                .get(id)
                .then()
                .body("year", equalTo(expMovie.getYear()))
                .body("director", equalTo(expMovie.getDirector()))
                .body("title", equalTo(expMovie.getTitle()));
    }


}
