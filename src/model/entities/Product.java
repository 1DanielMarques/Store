package model.entities;

import model.services.TaxService;

public class Product implements TaxService {

    private static final Double TAX = 0.05;
    private String name;
    private Integer quantity;
    private Double price;

    public Product(String name, Integer quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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

    @Override
    public double feePayment(int quantity, double price) {
        return this.price * this.quantity * TAX;
    }

    @Override
    public double totalPrice() {
        return getPrice() * getQuantity();
    }
}
