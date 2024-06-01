package ru.praktikum.steps;

import io.restassured.response.ValidatableResponse;
import ru.praktikum.model.Order;

import static io.restassured.RestAssured.given;
import static ru.praktikum.config.ApiConfig.CANCEL_ORDER;
import static ru.praktikum.config.ApiConfig.ORDERS;

public class OrderSteps {

    public ValidatableResponse create(Order order) {
        return given()
                .body(order)
                .when()
                .post(ORDERS)
                .then();
    }

    public ValidatableResponse list() {
        return given()
                .when()
                .get(ORDERS)
                .then();
    }

    public ValidatableResponse cancel(int track) {
        return given()
                .body("{\n" +
                        "    \"track\": " + track + "\n" +
                        "}")
                .when()
                .put(CANCEL_ORDER)
                .then();
    }
}
