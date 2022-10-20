package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.Product;
import model.services.PriceService;
import model.services.PriceWithTaxService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int id = 1;
        char option = 'y';
        double total = 0;

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        Client client = new Client(name, email);
        do {
            Order order = new Order(client, id);
            id++;
            do {
                System.out.println("-Product Data-");
                System.out.print("Name: ");
                sc.nextLine();
                String productName = sc.nextLine();
                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                System.out.print("Price: $");
                double price = sc.nextDouble();
                order.addProducts(new Product(productName, quantity, price, new PriceWithTaxService()));
                System.out.print("Add another product? (y/n): ");
                option = sc.next().charAt(0);

            } while (option == 'y');
            client.addOrder(order);
            System.out.print("Another order? (y/n): ");
            option = sc.next().charAt(0);
        } while (option == 'y');
        System.out.println("-Client-");
        System.out.println(client);
        for (Order o : client.getOrderList()) {
            o.data();
            total += o.totalValueOrder();
            System.out.println();
        }
        System.out.println("Total Orders: $" + String.format("%.2f", total));

    }
}
