package model.entities;

import model.services.OrderDataService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Client client;
    private Integer id;
    private List<Product> products = new ArrayList<>();
    private LocalDateTime dateTime;
    private OrderDataService orderDataService;

    public Order(Client client, Integer id, OrderDataService orderDataService) {
        this.client = client;
        this.id = id;
        this.dateTime = LocalDateTime.now();
        this.orderDataService = orderDataService;
    }

    public Client getClient() {
        return client;
    }

    public Integer getId() {
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

    public void orderData() {
        this.orderDataService.data(this);
    }


}
