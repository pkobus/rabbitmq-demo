package pl.isolution.rabbitmqdemo.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderQueuesRabbitMQConfig {

    public static final String ORDER_CONFIRMATION_EMAIL_QUEUE = "order-confirmation-email";
    public static final String ORDER_EXCHANGE = "order";
    public static final String ORDER_PLACED_ROUTING_KEY = "order.placed";

    @Bean
    public Queue orderConfirmationEmailQueue() {
        return new Queue(ORDER_CONFIRMATION_EMAIL_QUEUE);
    }

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(ORDER_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue orderConfirmationEmailQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(orderConfirmationEmailQueue).to(orderExchange).with(ORDER_PLACED_ROUTING_KEY);
    }

}
