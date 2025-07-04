package exceptions;

import pojos.Cart;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException(Cart c) {
        super("Cart is empty, please, at least add a single item." + " Current Items count: " + c.getItemsCount());

    }
}
