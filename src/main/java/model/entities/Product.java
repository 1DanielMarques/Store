package model.entities;

import model.services.PriceService;

public class Product {

    private static final double TAX = 0.05;
    private String name;
    private int quantity;
    private double price;
    private PriceService priceService;

    public Product(String name, int quantity, double price, PriceService priceService) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double totalPrice() {
        return priceService.totalPrice(this);
    }
/*
    @Override
    public String toString() {
        return "Name: " + this.name
                + ", Price: $" + getPrice()
                + ", Quantity: " + this.quantity;
    }*/

}
