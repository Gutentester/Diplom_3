package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import user.User;

import static constants.URLs.*;
import static io.restassured.RestAssured.given;

public class API {

    @Step
    public static Response loginUser(User user) {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(BASE_URL + LOGIN_USER);
        return response;
    }

    @Step
    public static String getToken(User user) {
        return loginUser(user).then().extract().path("accessToken");
    }

    @Step
    public static void removeUser(String token) {
        if (token != null)
            given()
                    .header("Authorization", token)
                    .when()
                    .delete(BASE_URL + REMOVE_USER);
    }
}
