package client;


import helper.ClientApi;
import io.restassured.response.ValidatableResponse;
import org.example.CreateUser;
import org.example.LoginUser;
import org.junit.After;
import org.junit.Before;

public class BaseClientTest {

    protected CreateUser createUserRequest;
    protected LoginUser userLoginRequest;
    protected CreateUser user;
    protected String token;
    protected ValidatableResponse responseUpdate;
    protected ValidatableResponse responseTwice;
    protected ValidatableResponse response;
    protected ValidatableResponse login;


    @Before
    public void setup() {
        user = CreateUser.getRandomUser();
        createUserRequest = CreateUser.getRandomUser();
    }

    @After
    public void tearDown() {
        if (token == null) return;
        ClientApi.deleteUser(user, token);
        ClientApi.deleteUser(createUserRequest, token);
    }
}
