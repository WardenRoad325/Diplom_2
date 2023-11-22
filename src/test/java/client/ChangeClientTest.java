package client;


import helper.ClientApi;
import io.qameta.allure.junit4.DisplayName;

import org.apache.http.HttpStatus;

import org.example.LoginUser;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ChangeClientTest extends BaseClientTest {

    @Test
    @DisplayName("change authorization user /api/auth/user")
    public void changeAuthorizationUserTest() {
        userLoginRequest = LoginUser.getRandomUser();

        response = ClientApi.registrationUser(user);
        token = response.extract().path("accessToken");
        responseUpdate = ClientApi.changeUserWithAuth(userLoginRequest, token);
        responseUpdate
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("change without authorization user /api/auth/user")
    public void changeWithoutAuthorizationUserTest() {
        userLoginRequest = LoginUser.getRandomUser();

        response = ClientApi.registrationUser(user);
        token = response.extract().path("accessToken");
        responseUpdate = ClientApi.changeUserWithoutAuth(userLoginRequest);
        responseUpdate
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("You should be authorised"));
    }
}
