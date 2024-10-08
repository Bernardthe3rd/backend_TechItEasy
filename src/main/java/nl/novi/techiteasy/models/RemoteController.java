package nl.novi.techiteasy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "RemoteControllers")
public class RemoteController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private double price;
    private int originalStock;

    @OneToOne(mappedBy = "remoteController")
    private Television television;

//    public RemoteController() {
//    }
//
//    public RemoteController(long id, String compatibleWith, String batteryType, String name, String brand, double price, int originalStock) {
//        this.id = id;
//        this.compatibleWith = compatibleWith;
//        this.batteryType = batteryType;
//        this.name = name;
//        this.brand = brand;
//        this.price = price;
//        this.originalStock = originalStock;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
