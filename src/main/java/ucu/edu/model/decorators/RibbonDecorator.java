package ucu.edu.model.decorators;

import ucu.edu.model.Item;
import ucu.edu.model.ItemDecorator;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 40;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", in a ribbon";
    }
}
