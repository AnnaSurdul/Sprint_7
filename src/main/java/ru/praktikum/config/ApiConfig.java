package ru.praktikum.config;

public class ApiConfig {
    public static final String HOST = "https://qa-scooter.praktikum-services.ru";

    public static final String COURIER = "/api/v1/courier";
    public static final String LOGIN = "/api/v1/courier/login";
    public static final String DELETE_COURIER = "/api/v1/courier/{id}";
    public static final String ORDERS = "/api/v1/orders";
    public static final String CANCEL_ORDER = "/api/v1/orders/cancel";
}
