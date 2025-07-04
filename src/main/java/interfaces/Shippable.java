package interfaces;

/**
 * Represents an interface for shippable items.
 */
public interface Shippable {

    /**
     * Gets the name of the shippable item.
     *
     * @return the name of the item
     */
    String getName();

    /**
     * The fixed shipping fees for the item.
     */
    double SHIPPING_FEES = 30.0;

    /**
     * Gets the weight of the shippable item.
     *
     * @return the weight of the item
     */
    Double getWeight();
}
