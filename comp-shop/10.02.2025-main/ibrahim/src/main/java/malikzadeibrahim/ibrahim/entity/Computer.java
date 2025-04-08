package malikzadeibrahim.ibrahim.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Computer {

    @Id
    private Long id;
    private String brand;
    private String model;
    private Double price;

    public Computer() {}

    public Computer(Long id, String brand, String model, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
