package msg.connection.springboot_rbmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProd {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String keys;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProd.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        logger.info(String.format("Message Sent ->> %s", message));
        rabbitTemplate.convertAndSend(exchangeName, keys, message);
    }
}
