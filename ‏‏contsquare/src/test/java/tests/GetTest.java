package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetTest extends TestBase {

    @Test(description = "Get exist movie - funcional test")
    public void getExistMovie() {
        String id = "2";

        apiClient.prepareMovieByUpdate(id, defaultMovieObj);

        RestAssured.given()
                .when()
                .get(id)
                .then()
                .statusCode(200)
                .body("year", equalTo(defaultMovieObj.getYear()))
                .body("director", equalTo(defaultMovieObj.getDirector()))
                .body("title", equalTo(defaultMovieObj.getTitle()));
    }


    @Test(description = "Get not exist movie")
    public void getNotExistMovie() {
        String id  = utils.getRandomInteger(10,50)+"";

        apiClient.prepareMovieByDelete(id);
        RestAssured.given()
                .when()
                .get(id)
                .then()
                .statusCode(204);

    }

    @Test(description = "Reset environment by API")
    public void resetEnv() {

        RestAssured.given()
                .when()
                .get("/reset")
                .then()
                .statusCode(200);

    }




}
