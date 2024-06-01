package ru.praktikum.utils;

import org.apache.commons.lang3.RandomUtils;
import ru.praktikum.model.Color;
import ru.praktikum.model.Courier;
import ru.praktikum.model.Order;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class ApiRequestBuilder {

    public static Courier courierCreateOrLoginRequest() {
        return Courier.builder()
                .login(randomAlphabetic(10))
                .password(randomAlphabetic(10))
                .build();
    }

    public static Courier courierCreateRequestWithoutLogin() {
        return Courier.builder()
                .password(randomAlphabetic(10))
                .build();
    }

    public static Courier courierCreateRequestWithoutPassword() {
        return Courier.builder()
                .login(randomAlphabetic(10))
                .build();
    }

    public static Order createOrderRequest(List<Color> colors) {
        return Order.builder()
                .firstName(randomAlphabetic(10))
                .lastName(randomAlphabetic(10))
                .address(randomAlphabetic(10))
                .metroStation(RandomUtils.nextInt(1, 237))
                .phone(randomNumeric(12))
                .rentTime(RandomUtils.nextInt(1, 7))
                .deliveryDate("2024-06-06")
                .comment(randomAlphabetic(10))
                .color(colors)
                .build();
    }
}
