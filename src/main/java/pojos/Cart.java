package pojos;

import exceptions.CartEmptyException;
import exceptions.ProductOutOfStockException;
import interfaces.Shippable;

import java.util.HashMap;
import java.util.Map;

/**
     * Represents a shopping cart that holds shippable products and their quantities.
     * Provides methods to add items, calculate totals, and retrieve cart details.
     */
    public class Cart {
        // Stores the items in the cart with their quantities
        HashMap<ShippableProduct, Integer> items = new HashMap<>();
        // Stores the subtotal of the cart
        private double subtotal = 0;

        /**
         * Retrieves the items in the cart.
         *
         * @return A HashMap of ShippableProduct and their quantities.
         */
        public HashMap<ShippableProduct, Integer> getItems() {
            return items;
        }

        /**
         * Adds a product to the cart.
         *
         * @param sp The shippable product to add.
         * @param cartQuantity The quantity of the product to add.
         * @throws ProductOutOfStockException If the product quantity is insufficient.
         */
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

        /**
         * Checks if the cart is empty.
         *
         * @return true if the cart is empty, false otherwise.
         */
        public boolean isCartEmpty() {
            return this.items.isEmpty();
        }

        /**
         * Calculates the total number of items in the cart.
         *
         * @return The total count of items in the cart.
         */
        public int getItemsCount() {
            int itemsCount = 0;
            for (Map.Entry<ShippableProduct, Integer> productIntegerEntry : items.entrySet()) {
                itemsCount += productIntegerEntry.getValue();
            }
            return itemsCount;
        }

        /**
         * Calculates the subtotal of the cart based on product prices and quantities.
         *
         * @return The subtotal of the cart.
         * @throws CartEmptyException If the cart is empty.
         */
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

        /**
         * Calculates the total amount to be paid, including shipping fees.
         *
         * @return The total paid amount.
         */
        public double calculatePaidAmount() {
            return calculateSubtotal() + Shippable.SHIPPING_FEES;
        }

        /**
         * Calculates the total weight of all items in the cart.
         *
         * @return The total weight of the cart items.
         */
        public double calculateTotalWeights() {
            double totalWeight = 0.0;
            for (Map.Entry<ShippableProduct, Integer> productWeightEntry : items.entrySet()) {
                totalWeight += productWeightEntry.getKey().getWeight();
            }
            return totalWeight;
        }

        /**
         * Returns a string representation of the cart.
         *
         * @return A string describing the cart items.
         */
        @Override
        public String toString() {
            return "Cart Items: " +
                    "{items= " + items.toString() + "}";
        }
    }
