package model.services;

public class PriceWithTaxService implements PriceService {

    private static final double TAX = 0.03;

    @Override
    public double feePayment(double price) {
        return price * TAX;
    }

    @Override
    public double totalPrice(double price, int quantity) {
        return price * quantity;
    }
}
