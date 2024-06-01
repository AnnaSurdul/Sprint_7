package ru.praktikum.courier;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.praktikum.ConfigTest;
import ru.praktikum.model.Courier;
import ru.praktikum.steps.CouriersSteps;

import static ru.praktikum.utils.ApiRequestBuilder.*;

public class CourierCreateNegativeTest extends ConfigTest {
    private final CouriersSteps couriersSteps = new CouriersSteps();
    private Courier courier;

    @Test
    @DisplayName("Create two identical couriers")
    public void createTwoIdenticalCouriers() {
        courier = courierCreateOrLoginRequest();
        couriersSteps
                .create(courier);
        couriersSteps
                .create(courier)
                .statusCode(409);
    }

    @Test
    @DisplayName("Create courier without login")
    public void createCourierWithoutLogin() {
        courier = courierCreateRequestWithoutLogin();
        couriersSteps
                .create(courier)
                .statusCode(400);
    }

    @Test
    @DisplayName("Create courier without password")
    public void createCourierWithoutPassword() {
        courier = courierCreateRequestWithoutPassword();
        couriersSteps
                .create(courier)
                .statusCode(400);
    }

    @After
    public void destroy() {
        if (courier.getLogin() != null && courier.getPassword() != null){
            couriersSteps.delete(couriersSteps.login(courier)
                    .extract().body().path("id"));
        }
    }
}
