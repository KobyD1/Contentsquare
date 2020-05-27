package tests;

import infra.Movie;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class SecurityTest extends TestBase {



    @Test(description = "Try to reset environment by not authorized user/incorrect password")
    public void resetEnvByNotAuth() {

        RestAssured.given()
                .auth()
                .preemptive()
                .basic("user", "password")
                .when()
                .get("/reset")
                .then()
                .statusCode(401);
    }

    @Test(description = "Try to reset environment by authorized user/Incorrect password")
    public void resetEnvByAuthUserIncorrectPassword() {

        RestAssured.given()
                .auth()
                .preemptive()
                .basic("koby", "password")
                .when()
                .get("/reset")
                .then()
                .statusCode(401);

    }


    @Test(description = "Try to delete by not authorized user/Incorrect password")
    public void deleteEnvByNotAuthUserIncorrectPassword() {
        String id = "5";

        RestAssured.given()
                .auth()
                .preemptive()
                .basic("user", "password")
                .when()
                .delete(id)
                .then()
                .statusCode(401);


    }

}
