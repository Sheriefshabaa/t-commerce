package services;

import exceptions.InsufficientFundsException;
import pojos.Cart;
import pojos.Customer;


/**
     * Service class for managing a shopping cart.
     */
    public class CartService {
        private Cart cart;

        /**
         * Constructs a CartService with the specified cart.
         *
         * @param cart the cart to be managed by this service
         */
        public CartService(Cart cart) {
            this.cart = cart;
        }

        /**
         * Retrieves the cart associated with this service.
         *
         * @return the cart
         */
        public Cart getCart() {
            return cart;
        }

        /**
         * Processes the checkout for a customer. Deducts the cart's total amount
         * from the customer's balance if sufficient funds are available.
         * Throws an InsufficientFundsException if the customer does not have
         * enough balance.
         *
         * @param c the customer attempting to checkout
         * @throws InsufficientFundsException if the customer's balance is insufficient
         */
        public void checkout(Customer c) {
            if (c.getBalance() > cart.calculateSubtotal()) {
                c.setBalance(c.getBalance() - cart.calculatePaidAmount());
            } else {
                throw new InsufficientFundsException(c, this.cart);
            }
        }
    }
