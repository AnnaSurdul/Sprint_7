package ru.praktikum.courier;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.ConfigTest;
import ru.praktikum.model.Courier;
import ru.praktikum.steps.CouriersSteps;

import static org.hamcrest.Matchers.notNullValue;
import static ru.praktikum.utils.ApiRequestBuilder.courierCreateOrLoginRequest;

public class CourierLoginPositiveTest extends ConfigTest {
    private final CouriersSteps couriersSteps = new CouriersSteps();
    private Courier courier;

    @Before
    public void init() {
        courier = courierCreateOrLoginRequest();
    }

    @Test
    @DisplayName("Login courier success")
    public void LoginCourierSuccess() {
        couriersSteps
                .create(courier);
        couriersSteps
                .login(courier)
                .statusCode(200);
    }

    @Test
    @DisplayName("Should return id")
    public void shouldReturnId() {
        couriersSteps
                .create(courier);
        couriersSteps
                .login(courier)
                .body("id", notNullValue());
    }

    @After
    public void destroy() {
        couriersSteps.delete(couriersSteps.login(courier)
                .extract().body().path("id"));
    }
}
