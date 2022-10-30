package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class HelloConsumer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "spring-test"),
            key = "routing-key",
            exchange = @Exchange("spring-exchange")))
    public void listener(String message) throws IOException, InterruptedException {
        log.info("Message = {}, Properties: {}", message);
    }
}
