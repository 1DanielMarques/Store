package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.Product;
import model.services.PriceWithTaxService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static char option = 'y';

    public static void main(String[] args) {
        int id = 1;

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        Client client = new Client(name, email);
        do {
            Order order = new Order(client, id);
            id++;
            do {
                try {
                    productData(order);
                } catch (InputMismatchException e) {
                    e.printStackTrace();
                }
            } while (option == 'y');
            client.addOrder(order);
            do {
                System.out.print("Another order? (y/n): ");
                option = sc.next().charAt(0);
            } while (option != 'y' && option != 'n');
        } while (option == 'y');
        registerInFile(client);
    }

    public static void productData(Order order) {
        System.out.println("-Product Data-");
        System.out.print("Name: ");
        sc.nextLine();
        String productName = sc.nextLine();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Price: $");
        double price = sc.nextDouble();
        order.addProducts(new Product(productName, quantity, price, new PriceWithTaxService()));
        do {
            System.out.print("Add another product? (y/n): ");
            option = sc.next().charAt(0);
        } while (option != 'y' && option != 'n');
    }

    public static void registerInFile(Client client) {
        final String PATH = "C:\\Users\\nohax\\OneDrive\\Área de Trabalho\\Software\\REPOSITORIOS\\Projetos\\Store\\summary\\out.txt";
        double total = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))) {
            bw.write("-Client-");
            bw.newLine();
            bw.write(client.toString());
            bw.newLine();
            for (Order o : client.getOrderList()) {
                bw.write(o.toString());
                bw.newLine();
                for (Product p : o.getProducts()) {
                    bw.write(p.toString());
                    bw.newLine();
                }
                bw.write("Total: $" + o.totalValueOrder());
                bw.newLine();
                total += o.totalValueOrder();
            }
            bw.write("Total Orders: $" + String.format("%.2f", total));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
