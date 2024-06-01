package ru.praktikum.order;

import io.qameta.allure.junit4.DisplayName;
import lombok.RequiredArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.ConfigTest;
import ru.praktikum.model.Color;
import ru.praktikum.model.Order;
import ru.praktikum.steps.OrderSteps;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static ru.praktikum.model.Color.BLACK;
import static ru.praktikum.model.Color.GRAY;
import static ru.praktikum.utils.ApiRequestBuilder.createOrderRequest;

@RunWith(Parameterized.class)
@RequiredArgsConstructor
public class CreateOrderTest extends ConfigTest {

    private OrderSteps orderSteps = new OrderSteps();
    private Order order;

    private int track;

    private final List<Color> colors;

    @Parameterized.Parameters
    public static Object[][] color() {
        return new Object[][]{
                {List.of(BLACK, GRAY)},
                {List.of(BLACK)},
                {List.of(GRAY)},
                {List.of()}
        };
    }

    @Before
    public void init() {
        order = createOrderRequest(colors);
    }

    @Test
    @DisplayName("Test create order")
    public void testCreateOrder() {
        track = orderSteps
                .create(order)
                .statusCode(201)
                .extract()
                .body()
                .path("track");
    }

    @Test
    @DisplayName("Should return track")
    public void shouldReturnTrack() {
        track = orderSteps
                .create(order)
                .body("track", notNullValue())
                .extract()
                .body()
                .path("track");
    }

    @After
    public void destroy() {
        orderSteps.cancel(track);
    }
}
