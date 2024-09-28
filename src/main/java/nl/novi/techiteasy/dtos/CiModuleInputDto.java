package nl.novi.techiteasy.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CiModuleInputDto {

    @NotNull(message = "name may not be empty")
    private String name;
    @NotNull(message = "type may not be empty")
    private String type;
    @PositiveOrZero(message = "price has to be zero or a positive number")
    private double price;

    public @NotNull(message = "name may not be empty") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name may not be empty") String name) {
        this.name = name;
    }

    public @NotNull(message = "type may not be empty") String getType() {
        return type;
    }

    public void setType(@NotNull(message = "type may not be empty") String type) {
        this.type = type;
    }

    @PositiveOrZero(message = "price has to be zero or a positive number")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "price has to be zero or a positive number") double price) {
        this.price = price;
    }
}
