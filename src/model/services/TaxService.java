package model.services;

public interface TaxService {

    double feePayment(int quantity, double price);
    double totalPrice();

}
