package com.example.courier;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CreateCourierPosTest {
    private final CourierGenerator generator = new CourierGenerator();
    private final CourierClient client = new CourierClient();
    private final CourierAssertions check = new CourierAssertions();
    protected int courierId;
    @After
    public void deleteCourier() {
        client.deleteCourier(courierId);
    }

    @Test
    @DisplayName("Курьера можно создать")
    public void createCourierAndLogInSuccesfully() {
        var courier = generator.random();
        ValidatableResponse courierResponse = client.createCourier(courier);
        check.createdSuccessfully(courierResponse);
    }
}
