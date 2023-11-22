package helper;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateApi {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    public static RequestSpecification getPostSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build()
                .given()
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter());
    }

    public static RequestSpecification getPostSpecAuth(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", token)
                .build()
                .given()
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter());
    }
}
