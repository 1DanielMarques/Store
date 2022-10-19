package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Client client;
    private int id;
    private List<Product> products = new ArrayList<>();
    private LocalDateTime dateTime;
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Order(Client client, int id) {
        this.client = client;
        this.id = id;
        this.dateTime = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public double totalValueOrder() {
        double sum = 0;
        for (Product p : products) {
            sum += p.totalPrice();
        }
        return sum;
    }

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
