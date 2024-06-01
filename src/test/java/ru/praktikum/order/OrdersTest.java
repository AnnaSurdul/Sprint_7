package ru.praktikum.order;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;
import ru.praktikum.ConfigTest;
import ru.praktikum.steps.OrderSteps;

import java.util.List;

public class OrdersTest extends ConfigTest {
    private OrderSteps orderSteps = new OrderSteps();

    @Test
    @DisplayName("Test orders")
    public void testOrders() {
        orderSteps
                .list()
                .body("orders", Matchers.any(List.class));
    }
}
