package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private String email;
    private List<Order> orderList = new ArrayList<>();

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
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

    @Override
    public String toString(){
        return "Name: " + this.name
                + " | Email: " + this.email;
    }

}