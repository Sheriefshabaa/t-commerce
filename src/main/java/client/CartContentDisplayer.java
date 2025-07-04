package client;

import interfaces.Shippable;
import pojos.Cart;
import pojos.Customer;
import pojos.ShippableProduct;

import java.util.Map;

public class CartContentDisplayer {
    public static void printCartContent(Cart cart) {
        for (Map.Entry<ShippableProduct, Integer> product : cart.getItems().entrySet()) {
            System.out.printf("%dx%-16sg%-32s\n", product.getValue(), product.getKey().getProductName(), product.getKey().getWeight());
        }
    }

    public static void printBillContent(Cart cart) {
        System.out.printf("%-16s%8.1f\n", "subtotal", cart.calculateSubtotal());
        System.out.printf("%-16s%8.1f\n", "Shipping", Shippable.SHIPPING_FEES);
        System.out.printf("%-16s%8.1f\n", "Amount", cart.calculatePaidAmount());


    }
}
