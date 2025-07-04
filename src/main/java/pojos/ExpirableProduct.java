package pojos;

import java.time.LocalDate;


public abstract class ExpirableProduct extends Product {
    private LocalDate date;

    public ExpirableProduct(String name, Integer quantity, Double price) {
        super(name, quantity, price);
        date = LocalDate.now().plusWeeks(3);
    }
}
