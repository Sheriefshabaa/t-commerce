package services;

import exceptions.InsufficientFundsException;
import pojos.Cart;
import pojos.Customer;


public class CartService {
    private Cart cart;


    public CartService(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void checkout(Customer c) {
        if (c.getBalance() > cart.calculateSubtotal()) {
            c.setBalance(c.getBalance() - cart.calculatePaidAmount());
        } else {
            throw new InsufficientFundsException(c, this.cart);
        }
    }


}
