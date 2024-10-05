package nl.novi.techiteasy.dtos;

import nl.novi.techiteasy.AvailableSize;

import java.time.LocalDate;
import java.util.List;

public class TelevisionDto {

    //    dit veld mag in je output dto komen.
    private Long id;
    private String type;
    private String brand;
    private String name;
    private double price;
    private AvailableSize availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private int originalStock;
    private int sold;
    private LocalDate lastSold;
    public RemoteControllerDto remoteController;
    public CiModuleDto ciModule;
    public List<WallBracketDto> wallBracket;

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AvailableSize getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(AvailableSize availableSize) {
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

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
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

    public LocalDate getLastSold() {
        return lastSold;
    }

    public void setLastSold(LocalDate lastSold) {
        this.lastSold = lastSold;
    }

    public RemoteControllerDto getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteControllerDto remoteController) {
        this.remoteController = remoteController;
    }

    public CiModuleDto getCiModule() {
        return ciModule;
    }

    public void setCiModule(CiModuleDto ciModule) {
        this.ciModule = ciModule;
    }

    public List<WallBracketDto> getWallBracket() {
        return wallBracket;
    }

    public void setWallBracket(List<WallBracketDto> wallBracket) {
        this.wallBracket = wallBracket;
    }
}
