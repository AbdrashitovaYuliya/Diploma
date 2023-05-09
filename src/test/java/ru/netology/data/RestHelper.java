package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static ru.netology.util.PropertyUtils.prop;

public class RestHelper {
    private final static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(prop().getProperty("base.rest.url"))
            .setAccept(JSON)
            .setContentType(JSON)
            .log(ALL)
            .build();

    public final static ValidatableResponse postRequest(CardInfo cardInfo, String path) {
        return given()
                .spec(requestSpec)
                .body(cardInfo)
                .when()
                .post(path)
                .then();
    }
}
