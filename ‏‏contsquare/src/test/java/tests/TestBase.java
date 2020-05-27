package tests;

import infra.ApiClient;
import infra.Movie;
import infra.Utills;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    Movie defaultMovieObj = new Movie(1998, "David Fincher", "Fight Club");

    ApiClient apiClient = new ApiClient();
    Utills utils = new Utills();

    @BeforeMethod
    public void setup() {

        System.out.println("Try to init test preliminiary Params");
        RestAssured.baseURI = "http://3.84.187.196";
        RestAssured.port = 8081;
        RestAssured.basePath = "/api/movieservice";

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("koby");
        authScheme.setPassword("kd1234");
        RestAssured.authentication = authScheme;
    }





    @AfterMethod
    public void after() {
        apiClient.prepareEnvByReset();

    }

}