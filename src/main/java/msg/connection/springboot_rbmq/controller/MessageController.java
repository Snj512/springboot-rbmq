package msg.connection.springboot_rbmq.controller;

import msg.connection.springboot_rbmq.dto.User;
import msg.connection.springboot_rbmq.producer.RabbitMQProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send")
public class MessageController {

    @Autowired
    private RabbitMQProd rabbitMQProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message Transferred Successfully");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQProducer.sendJsonMessage(user);
        return ResponseEntity.ok("User Data sent successfully");
    }

}
