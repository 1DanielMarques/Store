package model.services;

public interface Price {

    double feePayment(double price);
    double totalPrice(double price, int quantity);

}
