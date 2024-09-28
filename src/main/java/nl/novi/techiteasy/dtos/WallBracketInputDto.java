package nl.novi.techiteasy.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class WallBracketInputDto {

    @NotNull(message = "size may not be empty")
    private String size;
    @NotEmpty(message = "please fill in true or false if the bracket is adjustable")
    private boolean adjustable;
    @NotNull(message = "name may not be empty")
    private String name;
    @PositiveOrZero(message = "price has to be zero or a positive number")
    private double price;

    public @NotNull(message = "size may not be empty") String getSize() {
        return size;
    }

    public void setSize(@NotNull(message = "size may not be empty") String size) {
        this.size = size;
    }

    @NotEmpty(message = "please fill in true or false if the bracket is adjustable")
    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(@NotEmpty(message = "please fill in true or false if the bracket is adjustable") boolean adjustable) {
        this.adjustable = adjustable;
    }

    public @NotNull(message = "name may not be empty") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name may not be empty") String name) {
        this.name = name;
    }

    @PositiveOrZero(message = "price has to be zero or a positive number")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "price has to be zero or a positive number") double price) {
        this.price = price;
    }
}
