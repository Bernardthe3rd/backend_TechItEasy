package nl.novi.techiteasy.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class RemoteControllerInputDto {

    @NotNull(message = "compatibleWith may not be empty")
    private String compatibleWith;
    @NotNull(message = "batteryType may not be empty")
    private String batteryType;
    @NotNull(message = "name may not be empty")
    private String name;
    @NotNull(message = "brand may not be empty")
    private String brand;
    @PositiveOrZero(message = "price has to be zero or a positive number")
    private double price;
    private int originalStock;

    public @NotNull(message = "compatibleWith may not be empty") String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(@NotNull(message = "compatibleWith may not be empty") String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public @NotNull(message = "batteryType may not be empty") String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(@NotNull(message = "batteryType may not be empty") String batteryType) {
        this.batteryType = batteryType;
    }

    public @NotNull(message = "name may not be empty") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name may not be empty") String name) {
        this.name = name;
    }

    public @NotNull(message = "brand may not be empty") String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull(message = "brand may not be empty") String brand) {
        this.brand = brand;
    }

    @PositiveOrZero(message = "price has to be zero or a positive number")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "price has to be zero or a positive number") double price) {
        this.price = price;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }
}
