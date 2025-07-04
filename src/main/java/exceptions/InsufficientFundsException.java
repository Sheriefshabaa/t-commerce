package exceptions;

import pojos.Cart;
import pojos.Customer;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(Customer c, Cart cart) {
        super("Sorry you don't have enough balance!\n" +
                "your current balance is: " + c.getBalance() + ",  bill total is: "+ cart.calculatePaidAmount());
    }
}
