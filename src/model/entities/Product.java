package model.entities;

import model.services.TaxService;

public class Product implements TaxService {

    private String name;
    private Integer quantity;
    private Double price;
    private Double totalPrice;

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
        return this.price * this.quantity * 0.05;
    }

    @Override
    public double totalPrice() {
        return this.price * this.quantity + this.feePayment(this.quantity, this.price);
    }
}
