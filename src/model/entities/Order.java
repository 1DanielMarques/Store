package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Client client;
    private Integer id;
    private List<Product> products = new ArrayList<>();

    public Order(Client client, Integer id) {
        this.client = client;
        this.id = id;
    }
}
