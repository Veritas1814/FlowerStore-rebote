package ucu.edu.model.decorators;
import ucu.edu.model.ItemDecorator;
import ucu.edu.model.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 13;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", in a paper";
    }
}

