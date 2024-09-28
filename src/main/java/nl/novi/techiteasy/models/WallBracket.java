package nl.novi.techiteasy.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Wallbrackets")
public class WallBracket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;
    private boolean adjustable;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "wallBracket")
    private List<Television> televisionList;

//    public WallBracket() {
//
//    }
//
//    public WallBracket(Long id, String size, boolean adjustable, String name, double price) {
//        this.id = id;
//        this.size = size;
//        this.adjustable = adjustable;
//        this.name = name;
//        this.price = price;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
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

    public List<Television> getTelevisionList() {
        return televisionList;
    }

    public void setTelevisionList(List<Television> televisionList) {
        this.televisionList = televisionList;
    }
}
