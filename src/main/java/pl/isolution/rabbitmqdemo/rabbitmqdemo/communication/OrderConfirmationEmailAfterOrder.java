package pl.isolution.rabbitmqdemo.rabbitmqdemo.communication;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pl.isolution.rabbitmqdemo.rabbitmqdemo.order.domain.OrderPlacedEvent;


@Component
public class OrderConfirmationEmailAfterOrder {

    private OrderConfirmationEmailService orderConfirmationEmailService;

    public OrderConfirmationEmailAfterOrder(OrderConfirmationEmailService orderConfirmationEmailService) {
        this.orderConfirmationEmailService = orderConfirmationEmailService;
    }

    @RabbitListener(queues = "order-confirmation-email")
    public void receive(@Payload OrderPlacedEvent orderPlacedEvent) throws InterruptedException {
        orderConfirmationEmailService.sendEmail(orderPlacedEvent.getOrderId());
    }

}
