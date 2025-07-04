package pojos;

import exceptions.CartEmptyException;
import exceptions.ProductOutOfStockException;
import interfaces.Shippable;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    HashMap<ShippableProduct, Integer> items = new HashMap<>();
    private double subtotal = 0;

    public HashMap<ShippableProduct, Integer> getItems() {
        return items;
    }

    public void add(ShippableProduct sp, Integer cartQuantity) {
        if (sp.getQuantity() < cartQuantity) {
            throw new ProductOutOfStockException(sp);
        } else if (!sp.isShippable()) {
            items.remove(sp.getProductName());
        } else {
            items.put(sp, cartQuantity);
            sp.updateQuantity(cartQuantity);
        }

    }

    public boolean isCartEmpty() {
        return this.items.isEmpty();
    }

    public int getItemsCount() {
        int itemsCount = 0;
        for (Map.Entry<ShippableProduct, Integer> productIntegerEntry : items.entrySet()) {
            itemsCount += productIntegerEntry.getValue();

        }
        return itemsCount;
    }

    public double calculateSubtotal() {

        if (!items.isEmpty()) {
            for (Map.Entry<ShippableProduct, Integer> productEntry : items.entrySet()) {
                Double productPrice = productEntry.getKey().getPrice();
                Integer productAmount = productEntry.getValue();
                subtotal += productPrice * productAmount;

            }
        } else {
            throw new CartEmptyException(this);
        }
        return subtotal;
    }

    public double calculatePaidAmount() {
        return calculateSubtotal() + Shippable.SHIPPING_FEES;

    }

    public double calculateTotalWeights() {
        double totalWeight = 0.0;
        for (Map.Entry<ShippableProduct, Integer> productWeightEntry : items.entrySet()) {
            totalWeight += productWeightEntry.getKey().getWeight();

        }
        return totalWeight;
    }


    @Override
    public String toString() {
        return "Cart Items: " +
                "{items= " + items.toString() + "}";
    }
}
