package edu.wit.senderp.inventorytrack;


public class Item {

    private  String name;
    private Double value;
    private int quantity;
    private String brand;
    private String description;

    public Item (String name, Double value, int quantity, String brand, String description) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.brand = brand;
        this.description = description;
    }
    // Add tag array here //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
