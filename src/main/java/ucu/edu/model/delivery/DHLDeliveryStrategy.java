package ucu.edu.model.delivery;

import ucu.edu.model.Item;
import java.util.List;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public boolean deliver(List<Item> items) {
        System.out.println("Delivering items via DHL.");
        return true;
    }
}
