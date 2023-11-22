package helper;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.OrderUser;

import static helper.CreateApi.getPostSpec;
import static helper.CreateApi.getPostSpecAuth;
import static io.restassured.RestAssured.given;

public class OrderApi {
    @Step("getting ingredients")
    public static ValidatableResponse getIngredients() {
        return given()
                .spec(getPostSpec())
                .when()
                .get("/api/ingredients")
                .then();
    }

    @Step("new order with authorization")
    public static ValidatableResponse createOrderWithAuth(String token, OrderUser order) {
        return given()
                .spec(getPostSpecAuth(token))
                .body(order)
                .when()
                .post("/api/orders")
                .then();
    }

    @Step("new order without authorization")
    public static ValidatableResponse createOrderWithoutAuth(OrderUser order) {
        return given()
                .spec(getPostSpec())
                .body(order)
                .when()
                .post("/api/orders")
                .then();
    }

    @Step("data about the order of a specific user with authorization")
    public static ValidatableResponse getOrderDataWithAuth(String token) {
        return given()
                .spec(getPostSpecAuth(token))
                .when()
                .get("/api/orders")
                .then();
    }

    @Step("data about a specific user's order without authorization")
    public static ValidatableResponse getOrderDataWithoutAuth() {
        return given()
                .spec(getPostSpec())
                .when()
                .get("/api/orders")
                .then();
    }
}