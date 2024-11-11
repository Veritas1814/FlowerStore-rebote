package ucu.edu.model;

import lombok.Getter;
import ucu.edu.model.delivery.Delivery;
import ucu.edu.model.payment.Payment;

import java.util.LinkedList;
import java.util.List;

public class Order {
    @Getter
    private List<Item> items = new LinkedList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void processOrder() {
        if (payment.pay(getTotalPrice())) {
            delivery.deliver(items);
        }
    }
}
