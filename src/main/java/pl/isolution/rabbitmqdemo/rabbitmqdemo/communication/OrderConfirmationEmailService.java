package pl.isolution.rabbitmqdemo.rabbitmqdemo.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OrderConfirmationEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConfirmationEmailService.class);

    public void sendEmail(int orderId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        LOGGER.info("Sending confirmation email for order {}", orderId);
    }

}
