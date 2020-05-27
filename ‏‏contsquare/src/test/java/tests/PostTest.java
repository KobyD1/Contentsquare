package tests;

import infra.Movie;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class PostTest extends TestBase {


    @Test(description = "Create movie with default values - Funcional test")
    public void createMovie() {

        String response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(defaultMovieObj)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .asString();
        apiClient.compareRespBodyByGet(response,defaultMovieObj);

    }

    @Test(description = "Create movie with not default values")
    public void createNotDefaultMovie() {

        Integer randomYear = utils.getRandomInteger(1950, 2030);
        Movie movieObj = new Movie(randomYear, "D1!@#$%^&", "{}ssaawqw|<>");

        String response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(movieObj)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .asString();
        apiClient.compareRespBodyByGet(response,movieObj);

    }

    @Test(description = "Create movie with missing /null values")
    public void createMovieWithNull() {

        Movie movieObj = new Movie(1998, "David Fincher", null);


        String response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(movieObj)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .asString();
        apiClient.compareRespBodyByGet(response,movieObj);

    }


    @Test(description = "Create movie with empty body - Low priority")
    public void createMovieEmptyBody() {
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .body("")
                        .when()
                        .post()
                        .then()
                        .statusCode(500);
    }



}
