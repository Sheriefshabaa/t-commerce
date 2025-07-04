package pojos;

import interfaces.Shippable;

/**
     * Represents a product that can be shipped.
     * Extends the `Product` class and implements the `Shippable` interface.
     */
    public class ShippableProduct extends Product implements Shippable {
        /**
         * The weight of the product.
         */
        Double weight;

        /**
         * Indicates whether the product is shippable.
         */
        private boolean isShippable = true;

        /**
         * Constructs a new `ShippableProduct` with the specified details.
         *
         * @param name     The name of the product.
         * @param quantity The quantity of the product.
         * @param price    The price of the product.
         * @param weight   The weight of the product.
         */
        public ShippableProduct(String name, Integer quantity, Double price, Double weight) {
            super(name, quantity, price);
            this.weight = weight;
        }

        /**
         * Checks if the product is shippable.
         *
         * @return `true` if the product is shippable, otherwise `false`.
         */
        public boolean isShippable() {
            return isShippable;
        }

        /**
         * Sets the shippable status of the product.
         *
         * @param shippable The new shippable status.
         * @throws NullPointerException if the product is not shippable.
         */
        public void setShippable(boolean shippable) {
            if (this.isShippable) {
                isShippable = shippable;
            } else {
                throw new NullPointerException("This product isn't shippable");
            }
        }

        /**
         * Gets the name of the product.
         *
         * @return The name of the product.
         */
        @Override
        public String getName() {
            return getProductName();
        }

        /**
         * Gets the weight of the product.
         *
         * @return The weight of the product.
         */
        @Override
        public Double getWeight() {
            return this.weight;
        }
    }
