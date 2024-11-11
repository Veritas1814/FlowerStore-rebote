package ucu.edu.model.decorators;

import ucu.edu.model.ItemDecorator;
import ucu.edu.model.Item;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 4;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", in a basket";
    }
}
