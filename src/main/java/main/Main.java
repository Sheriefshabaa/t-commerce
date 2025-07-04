package main;

import client.CartContentDisplayer;
import client.UserInterfaceDisplayer;
import exceptions.CartEmptyException;
import exceptions.InsufficientFundsException;
import exceptions.ProductOutOfStockException;
import pojos.Cart;
import pojos.Customer;
import pojos.ShippableProduct;
import services.CartService;

public class Main {
    public static void main(String[] args) {
        Cart c = getCart();
        Customer c1 = new Customer("Sherif", 20000.0);
        try {
            UserInterfaceDisplayer.customerInfo(c1);
            UserInterfaceDisplayer.printHeader("** SHIPMENT NOTICE **");
            CartService cartService = new CartService(c);
            cartService.checkout(c1);
        } catch (InsufficientFundsException | CartEmptyException | ProductOutOfStockException e) {
            System.out.println(e.getMessage());
        }
        CartContentDisplayer.printCartContent(c);
        System.out.printf("Total package weight: %4.2f\n", c.calculateTotalWeights());
        UserInterfaceDisplayer.printHeader("** CHECKOUT RECEIPT **");
        CartContentDisplayer.printBillContent(c);

    }

    private static Cart getCart() {
        ShippableProduct cheese = new ShippableProduct("Cheese", 8, 200.0, 400.0);
        ShippableProduct Mango = new ShippableProduct("Mango", 5, 200.0, 100.0);
        ShippableProduct TV = new ShippableProduct("TV", 1, 200.0, 1000.0);
        ShippableProduct carpet = new ShippableProduct("carpet", 2, 200.0, 150.0);
        carpet.setShippable(false);
        Cart c = new Cart();
        c.add(cheese, 3);
        c.add(TV, 1);
        c.add(carpet, 1);
        c.add(Mango, 3);
        return c;
    }
}

