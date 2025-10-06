package msg.connection.springboot_rbmq.consumer;

import msg.connection.springboot_rbmq.producer.RabbitMQProd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQCons {

    @Value("${rabbitmq.routing.key}")
    private String keys;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQCons.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message){
        logger.info(String.format("Received Message ->> %s", message));

    }

}
