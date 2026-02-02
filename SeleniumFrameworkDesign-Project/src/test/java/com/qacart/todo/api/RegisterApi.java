package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RegisterApi {

    private Cookies restAssuredCookies;
    private String accessToken;
    private String userId;

    public String getFirstName() {
        return firstName;
    }

    private String firstName;

    public String getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Cookies getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void register()
    {
        User user = new User("Asmaa","Newigy","test1@example.com","Qa-123456");
        Response response = given()
                                    .baseUri("https://qacart-todo.herokuapp.com")
                                    .header("Content-Type", "application/json")
                                    .body(user)
                                    .log().all()
                            .when()
                                    .post("/api/v1/users/register")
                            .then()
                                    .log().all()
                                    .extract().response();

        if(response.statusCode()!=201)
        {
            throw  new RuntimeException("Something went wrong with the request");
        }

        restAssuredCookies= response.getDetailedCookies();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
