package model.services;

import model.entities.Product;

public class PriceWithTaxService implements PriceService {

    private static final double TAX = 0.05;

    @Override
    public double feePayment(double price, int quantity) {
        return price * TAX * quantity;
    }

    @Override
    public double totalPrice(Product product) {
        double fee = feePayment(product.getPrice(), product.getQuantity());
        double totalPrice = product.getPrice() * product.getQuantity() + fee;
        return totalPrice;
    }
}
