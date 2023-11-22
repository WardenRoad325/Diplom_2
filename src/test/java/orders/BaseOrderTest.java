package orders;

import helper.ClientApi;
import io.restassured.response.ValidatableResponse;

import org.example.CreateUser;
import org.example.OrderUser;
import org.junit.After;
import org.junit.Before;


public class BaseOrderTest {

    protected CreateUser createUserRequest;
    protected CreateUser user;
    protected OrderUser order;
    protected String token;
    protected ValidatableResponse responseCrt;
    protected ValidatableResponse response;


    @Before
    public void setUp() {
        createUserRequest = CreateUser.getRandomUser();
        user = CreateUser.getRandomUser();
        order = new OrderUser();
    }

    @After
    public void tearDown() {
        if (token == null) return;
        ClientApi.deleteUser(createUserRequest, token);
        if (token == null) return;
        ClientApi.deleteUser(user, token);
    }
}
