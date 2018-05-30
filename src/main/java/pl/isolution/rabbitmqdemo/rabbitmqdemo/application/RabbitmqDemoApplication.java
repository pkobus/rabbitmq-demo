package pl.isolution.rabbitmqdemo.rabbitmqdemo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.isolution.rabbitmqdemo.rabbitmqdemo.order.domain.Order;
import pl.isolution.rabbitmqdemo.rabbitmqdemo.order.service.PlaceOrderService;

import java.util.Random;

@SpringBootApplication
@ComponentScan("pl.isolution.rabbitmqdemo.rabbitmqdemo")
public class RabbitmqDemoApplication implements CommandLineRunner {

    private final PlaceOrderService placeOrderService;

    @Autowired
    public RabbitmqDemoApplication(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            Order order = new Order();
            order.setOrderId(new Random().nextInt(1000));
            placeOrderService.placeOrder(order);
        }
    }
}
