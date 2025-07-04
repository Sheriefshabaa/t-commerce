package exceptions;

import pojos.Cart;

/**
 * Exception thrown when an operation is attempted on an empty cart.
 */
public class CartEmptyException extends RuntimeException {

    /**
     * Constructs a new CartEmptyException with a message indicating the cart is empty.
     *
     * @param c the cart object that triggered the exception
     */
    public CartEmptyException(Cart c) {
        super("Cart is empty, please, at least add a single item." + " Current Items count: " + c.getItemsCount());
    }
}