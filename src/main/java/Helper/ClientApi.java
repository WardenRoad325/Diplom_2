package Helper;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.CreateUser;
import org.example.LoginUser;

import static Helper.CreateApi.getPostSpec;
import static Helper.CreateApi.getPostSpecAuth;
import static io.restassured.RestAssured.given;


public class ClientApi {
    @Step("registration")
    public static ValidatableResponse registrationUser(CreateUser user) {
        return given()
                .spec(getPostSpec())
                .body(user)
                .when()
                .post("/api/auth/register")
                .then();
    }

    @Step("authorization")
    public static ValidatableResponse authorizationUser(CreateUser user) {
        return given()
                .spec(getPostSpec())
                .body(user)
                .when()
                .post("/api/auth/login")
                .then();
    }

    @Step("user delete")
    public static ValidatableResponse deleteUser(CreateUser user, String token) {
        return given()
                .spec(getPostSpecAuth(token))
                .body(user)
                .when()
                .delete("/api/auth/user")
                .then();
    }

    @Step("change user with authorization")
    public static ValidatableResponse changeUserWithAuth(LoginUser user, String token) {
        return given()
                .spec(getPostSpecAuth(token))
                .body(user)
                .when()
                .patch("/api/auth/user")
                .then();
    }

    @Step("change user without authorization")
    public static ValidatableResponse changeUserWithoutAuth(LoginUser user) {
        return given()
                .spec(getPostSpec())
                .body(user)
                .when()
                .patch("/api/auth/user")
                .then();
    }
}
