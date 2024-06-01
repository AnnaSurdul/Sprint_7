package ru.praktikum.courier;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.ConfigTest;
import ru.praktikum.model.Courier;
import ru.praktikum.steps.CouriersSteps;

import static org.hamcrest.Matchers.*;
import static ru.praktikum.utils.ApiRequestBuilder.courierCreateOrLoginRequest;

public class CourierCreatePositiveTest extends ConfigTest {
    private final CouriersSteps couriersSteps = new CouriersSteps();
    private Courier courier;

    @Before
    public void init() {
        courier = courierCreateOrLoginRequest();
    }

    @Test
    @DisplayName("Status code 200")
    public void statusCode() {
        couriersSteps
                .create(courier)
                .statusCode(201);
    }

    @Test
    @DisplayName("Request returns Ok: true")
    public void requestReturnsOkTrue() {
        couriersSteps
                .create(courier)
                .body("ok", is(true));
    }

    @After
    public void destroy() {
        couriersSteps.delete(couriersSteps.login(courier)
                .extract().body().path("id"));
    }
}
