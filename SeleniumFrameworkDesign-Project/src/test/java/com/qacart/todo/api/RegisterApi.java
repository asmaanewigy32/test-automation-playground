package com.qacart.todo.api;

import com.qacart.todo.configer.EndPoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private List<Cookie> restAssuredCookies;
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

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void register()
    {
        User user = UserUtils.generateRandomUser();
        Response response = given()
                                    .baseUri(ConfigUtils.getInstance().getBaseUrl())
                                    .header("Content-Type", "application/json")
                                    .body(user)
                                    .log().all()
                            .when()
                                    .post(EndPoints.API_REGISTER_ENDPOINT)
                            .then()
                                    .log().all()
                                    .extract().response();

        if(response.statusCode()!=201)
        {
            throw  new RuntimeException("Something went wrong with the request");
        }

        restAssuredCookies= response.getDetailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
