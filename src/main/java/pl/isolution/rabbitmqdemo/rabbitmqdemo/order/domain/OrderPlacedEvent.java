package pl.isolution.rabbitmqdemo.rabbitmqdemo.order.domain;

import lombok.Data;

@Data
public class OrderPlacedEvent {

    private int orderId;

    public OrderPlacedEvent() {
    }

    public OrderPlacedEvent(Order order) {
        this.orderId = order.getOrderId();
    }
}
