package model.entities;

import model.services.PriceService;

public class Product {

    private static final Double TAX = 0.05;
    private String name;
    private Integer quantity;
    private Double price;
    private PriceService priceService;

    public Product(String name, Integer quantity, Double price, PriceService priceService) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.priceService = priceService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double totalPrice() {
        return priceService.totalPrice(this);
    }

    @Override
    public String toString() {
        return "Name: " + this.name
                + ", Price: $" + getPrice()
                + ", Quantity: " + this.quantity;
    }

}
