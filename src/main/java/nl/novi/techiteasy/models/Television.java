package nl.novi.techiteasy.models;

import jakarta.persistence.*;
import nl.novi.techiteasy.AvailableSize;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String brand;
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private AvailableSize availableSize;
    private Integer refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;
    private LocalDate lastSold;

    @OneToOne(cascade = CascadeType.ALL)
    private RemoteController remoteController;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ci_module_id")
    private CiModule ciModule;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "television_wallbrackets",
            joinColumns = @JoinColumn(name = "television"),
            inverseJoinColumns = @JoinColumn(name = "wallbracket")
    )
    private List<WallBracket> wallBracket;

//    public Television() {
//    }
//
//    public Television(Long id, String type, String brand, String name, double price, double availableSize, int refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambiLight, int originalStock, int sold, LocalDate lastSold) {
//        this.id = id;
//        this.type = type;
//        this.brand = brand;
//        this.name = name;
//        this.price = price;
//        this.availableSize = availableSize;
//        this.refreshRate = refreshRate;
//        this.screenType = screenType;
//        this.screenQuality = screenQuality;
//        this.smartTv = smartTv;
//        this.wifi = wifi;
//        this.voiceControl = voiceControl;
//        this.hdr = hdr;
//        this.bluetooth = bluetooth;
//        this.ambiLight = ambiLight;
//        this.originalStock = originalStock;
//        this.sold = sold;
//        this.lastSold = lastSold;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
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

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public CiModule getCiModule() {
        return ciModule;
    }

    public void setCiModule(CiModule ciModule) {
        this.ciModule = ciModule;
    }

    public List<WallBracket> getWallBracket() {
        return wallBracket;
    }

    public void setWallBracket(List<WallBracket> wallBracket) {
        this.wallBracket = wallBracket;
    }
}
