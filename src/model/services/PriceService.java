package model.services;

public interface PriceService {

    double feePayment(double price);
    double totalPrice(double price, int quantity);

}
