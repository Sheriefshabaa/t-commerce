package pojos;

import interfaces.Shippable;

public class ShippableProduct extends Product implements Shippable {
    Double weight;
    private boolean isShippable = true;


    public ShippableProduct(String name, Integer quantity, Double price, Double weight) {
        super(name, quantity, price);
        this.weight = weight;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public void setShippable(boolean shippable) {
        if (this.isShippable) {
            isShippable = shippable;
        } else {
            throw new NullPointerException("This product isn't shippable");
        }
    }

    @Override
    public String getName() {
        return getProductName();
    }


    @Override
    public Double getWeight() {
        return this.weight;
    }
}
