package orders;

import helper.ClientApi;
import helper.OrderApi;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ReceivUserOrders extends BaseOrderTest {


    @Test
    @DisplayName("list orders with authorization /api/orders")
    public void ordersWithAuthorizationTest() {
        response = ClientApi.registrationUser(user);
        token = response.extract().path("accessToken");
        OrderApi.createOrderWithAuth(token, order);
        ValidatableResponse responseReceivingOrder = OrderApi.getOrderDataWithAuth(token);
        responseReceivingOrder
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("list orders without authorization /api/orders")
    public void ordersWithoutAuthorizationTest() {
        response = OrderApi.getOrderDataWithoutAuth();
        response
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("You should be authorised"));
    }
}