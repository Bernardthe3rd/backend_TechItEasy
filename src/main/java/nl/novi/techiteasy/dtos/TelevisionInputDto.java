package nl.novi.techiteasy.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TelevisionInputDto {

    @NotNull(message = "type may not be empty")
    private String type;
    @NotNull(message = "brand may not be empty")
    private String brand;
    @NotNull(message = "name may not be empty")
    private String name;
    @PositiveOrZero(message = "price has to be zero or a positive value")
    private double price;

    private double availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;

    @NotEmpty(message = "Please fill in true or false")
    private Boolean smartTv;
    @NotEmpty(message = "Please fill in true or false")
    private Boolean wifi;
    @NotEmpty(message = "Please fill in true or false")
    private Boolean voiceControl;
    @NotEmpty(message = "Please fill in true or false")
    private Boolean hdr;
    @NotEmpty(message = "Please fill in true or false")
    private Boolean bluetooth;
    @NotEmpty(message = "Please fill in true or false")
    private Boolean ambiLight;
    private int originalStock;
    private int sold;
    @PastOrPresent(message = "Date should not be in the future")
    private LocalDate lastSold;

    public @NotNull(message = "type may not be empty") String getType() {
        return type;
    }

    public void setType(@NotNull(message = "type may not be empty") String type) {
        this.type = type;
    }

    public @NotNull(message = "brand may not be empty") String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull(message = "brand may not be empty") String brand) {
        this.brand = brand;
    }

    public @NotNull(message = "name may not be empty") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name may not be empty") String name) {
        this.name = name;
    }

    @PositiveOrZero(message = "price has to be zero or a positive value")
    public double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "price has to be zero or a positive value") double price) {
        this.price = price;
    }

    public double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(double availableSize) {
        this.availableSize = availableSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public @NotEmpty(message = "Please fill in true or false") Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(@NotEmpty(message = "Please fill in true or false") Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public @NotEmpty(message = "Please fill in true or false") Boolean getWifi() {
        return wifi;
    }

    public void setWifi(@NotEmpty(message = "Please fill in true or false") Boolean wifi) {
        this.wifi = wifi;
    }

    public @NotEmpty(message = "Please fill in true or false") Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(@NotEmpty(message = "Please fill in true or false") Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public @NotEmpty(message = "Please fill in true or false") Boolean getHdr() {
        return hdr;
    }

    public void setHdr(@NotEmpty(message = "Please fill in true or false") Boolean hdr) {
        this.hdr = hdr;
    }

    public @NotEmpty(message = "Please fill in true or false") Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(@NotEmpty(message = "Please fill in true or false") Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public @NotEmpty(message = "Please fill in true or false") Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(@NotEmpty(message = "Please fill in true or false") Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public @PastOrPresent(message = "Date should not be in the future") LocalDate getLastSold() {
        return lastSold;
    }

    public void setLastSold(@PastOrPresent(message = "Date should not be in the future") LocalDate lastSold) {
        this.lastSold = lastSold;
    }
}
