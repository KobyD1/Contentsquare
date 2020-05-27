package tests;

import infra.Utills;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteTest extends TestBase {


    @Test(description = "Delete exist ID - funcional test ")
    public void deleteExistId() {
        String id = "5";
        // verify for movie exist before  test
        apiClient.compareRespCodeByGet(id, 200);

        RestAssured.given()
                .when()
                .delete(id)
                .then()
                .statusCode(200);

        // verify for movie not exist after  test
        apiClient.compareRespCodeByGet(id, 204);

    }


    @Test(description = "Delete not exist ID")
    public void deleteNotExistId() {
        String id = utils.getRandomInteger(10,20)+"";

        // send delete  movie - handle case it create before
        apiClient.prepareMovieByDelete(id);

        RestAssured.given()
                .when()
                .delete(id)
                .then()
                .statusCode(200);

        apiClient.compareRespCodeByGet(id, 204);

    }

}
