package client;

import pojos.Cart;
import pojos.ShippableProduct;

import java.util.Map;

public class CartContentDisplayer {
    public static void printCartContent(Cart cart) {
        for (Map.Entry<ShippableProduct, Integer> productIntegerEntry : cart.getItems().entrySet()) {
            System.out.println();

        }
    }
}
