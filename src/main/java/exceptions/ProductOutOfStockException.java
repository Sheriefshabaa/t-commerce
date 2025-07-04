package exceptions;

import pojos.Product;

/**
 * Exception thrown when a product is out of stock.
 */
public class ProductOutOfStockException extends RuntimeException {

    /**
     * Constructs a new ProductOutOfStockException with a detailed message
     * including the product name and available quantity.
     *
     * @param sp the product that is out of stock
     */
    public ProductOutOfStockException(Product sp) {
        super("Product is understock! Please try again later!\nProduct name: " + sp.getProductName()
                + ", available quantity: " + sp.getQuantity());
    }
}
