package ru.praktikum.steps;

import io.restassured.response.ValidatableResponse;
import ru.praktikum.model.Courier;

import static io.restassured.RestAssured.given;
import static ru.praktikum.config.ApiConfig.*;

public class CouriersSteps {

    public ValidatableResponse create(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(COURIER)
                .then();
    }

    public ValidatableResponse login(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(LOGIN)
                .then();
    }

    public ValidatableResponse delete(int id) {
        return given()
                .pathParam("id",id)
                .when()
                .delete(DELETE_COURIER)
                .then();
    }

    public ValidatableResponse login(String login, String password) {
        Courier courier = Courier.builder()
                .login(login)
                .password(password)
                .build();
        return given()
                .body(courier)
                .when()
                .post(LOGIN)
                .then();
    }
}
