package Client;

import Helper.ClientApi;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateClientTest extends BaseClientTest {


    @Test
    @DisplayName("register user /api/auth/register")
    public void registerUserTest() {
        response = ClientApi.registrationUser(createUserRequest);
        token = response.extract().path("accessToken");
        response
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("register user twice /api/auth/register")
    public void canNotRegisterUserTwiceTest() {
        response = ClientApi.registrationUser(createUserRequest);
        token = response.extract().path("accessToken");
        responseTwice = ClientApi.registrationUser(createUserRequest);
        responseTwice
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("User already exists"));
    }

    @Test
    @DisplayName("register user without email /api/auth/register")
    public void registerUserWithoutEmailTest() {
        createUserRequest.setEmail(null);
        response = ClientApi.registrationUser(createUserRequest);
        response
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("Email, password and name are required fields"));
    }

    @Test
    @DisplayName("register user without password /api/auth/register")
    public void registerUserWithoutPasswordTest() {
        createUserRequest.setPassword(null);
        response = ClientApi.registrationUser(createUserRequest);
        response
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("Email, password and name are required fields"));
    }

    @Test
    @DisplayName("register user without password /api/auth/register")
    public void registerUserWithoutNameTest() {
        createUserRequest.setName(null);
        response = ClientApi.registrationUser(createUserRequest);
        response
                .statusCode(HttpStatus.SC_FORBIDDEN)
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("Email, password and name are required fields"));
    }
}
