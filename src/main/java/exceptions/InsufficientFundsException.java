package exceptions;

import pojos.Cart;
import pojos.Customer;

/**
 * Exception thrown when a customer does not have sufficient funds to complete a transaction.
 */
public class InsufficientFundsException extends RuntimeException {

    /**
     * Constructs a new InsufficientFundsException with a detailed message.
     *
     * @param c    the customer whose balance is insufficient
     * @param cart the cart containing the items to be purchased
     */
    public InsufficientFundsException(Customer c, Cart cart) {
        super("Sorry you don't have enough balance!\n" +
                "your current balance is: " + c.getBalance() + ",  bill total is: "+ cart.calculatePaidAmount());
    }
}
