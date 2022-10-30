package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/send")
@RequiredArgsConstructor
public class SenderController {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/message")
    public String publishMessage() {
        log.info("Got Request to Send Message");
        String message = "Hello World";
        rabbitTemplate.convertAndSend("spring-exchange", "routing-key", message);

        return "Sent";
    }
}
