package model.services;

import model.entities.Order;
import model.entities.Product;

import java.time.format.DateTimeFormatter;

public class OrderDataImpl implements OrderDataService {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void data(Order order) {
        System.out.print("ID: " + order.getId());
        System.out.println("; Client: " + order.getClient().toString());
        System.out.println("; Date: " + order.getDateTime().format(fmt));
        System.out.print("Products: ");
        for (Product p : order.getProducts()) {
            System.out.print(p + "; ");
        }


}
}
