package exceptions;

import pojos.Product;

public class ProductOutOfStockException extends RuntimeException {

    public ProductOutOfStockException(Product sp) {
        super("Product is understock! Please try again later!\nProduct name: " + sp.getProductName()
                + ", available quantity: " + sp.getQuantity());
    }
}
