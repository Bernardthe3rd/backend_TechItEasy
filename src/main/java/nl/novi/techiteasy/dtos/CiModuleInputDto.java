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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
