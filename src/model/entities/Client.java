package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private Integer id;
    private String name;
    private String email;
    private List<Order> orderList = new ArrayList<>();

    public Client(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        getOrderList().add(order);
    }

}