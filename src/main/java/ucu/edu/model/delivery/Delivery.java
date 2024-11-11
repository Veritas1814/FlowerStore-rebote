package ucu.edu.model.delivery;
import ucu.edu.model.Item;
import java.util.List;

public interface Delivery {
    boolean deliver(List<Item> items);
}
