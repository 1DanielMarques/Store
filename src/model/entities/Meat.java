package model.entities;

public class Meat extends Product {

    public Meat(String name, Integer quantity, Double price) {
        super(name, quantity, price);
    }

    @Override
    public double feePayment(int quantity, double price) {
        return super.feePayment(quantity, price) + 0.5;
    }

    @Override
    public double totalPrice() {
        return super.totalPrice() + this.feePayment(super.getQuantity(), super.getPrice());
    }
}
