package pojos;

import java.time.LocalDate;

/**
 * Abstract class representing a generic product.
 */
public abstract class Product {
    private String name;
    private Integer quantity;
    private Double price;
    private boolean isExpirable;
    private LocalDate expiryDate;

    /**
     * Constructs a Product with the specified name, quantity, and price.
     *
     * @param name     the name of the product
     * @param quantity the quantity of the product
     * @param price    the price of the product
     */
    public Product(String name, Integer quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.isExpirable = false;

    }

    /**
     * Gets the name of the product.
     *
     * @return the product name
     */
    public String getProductName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the new name of the product
     */
    public void setProductName(String name) {
        this.name = name;
    }

    public boolean isExpirable() {
        return isExpirable;
    }

    public void setExpiryStatus(boolean expirable) {
        isExpirable = expirable;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        if (this.isExpirable) {
            this.expiryDate = expiryDate;
        } else
            throw new NullPointerException("This Product has no expiry date");
    }

    /**
     * Gets the quantity of the product.
     *
     * @return the product quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     *
     * @param quantity the new quantity of the product
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Updates the quantity of the product by deducting a specified amount.
     *
     * @param deductedQuantity the amount to deduct from the current quantity
     */
    public void updateQuantity(Integer deductedQuantity) {
        this.quantity -= deductedQuantity;
    }

    /**
     * Gets the price of the product.
     *
     * @return the product price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the new price of the product
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
