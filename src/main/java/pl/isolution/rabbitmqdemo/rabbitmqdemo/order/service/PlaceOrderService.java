package pl.isolution.rabbitmqdemo.rabbitmqdemo.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.isolution.rabbitmqdemo.rabbitmqdemo.config.OrderQueuesRabbitMQConfig;
import pl.isolution.rabbitmqdemo.rabbitmqdemo.order.domain.Order;
import pl.isolution.rabbitmqdemo.rabbitmqdemo.order.domain.OrderPlacedEvent;

import java.util.concurrent.TimeUnit;

@Service
public class PlaceOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceOrderService.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PlaceOrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void placeOrder(Order order) throws InterruptedException {
        OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent(order);
        LOGGER.info("Placing order {}", order);
        TimeUnit.MILLISECONDS.sleep(100);
        rabbitTemplate.convertAndSend(OrderQueuesRabbitMQConfig.ORDER_EXCHANGE, OrderQueuesRabbitMQConfig.ORDER_PLACED_ROUTING_KEY, orderPlacedEvent);
    }

}
