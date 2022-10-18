package model.services;

import model.entities.Product;

public interface PriceService {

    double feePayment(double price, int quantity);
    double totalPrice(Product product);

}
