package com.root.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload , String exchange , String routingKey ){
        log.info("publishing to exchange {} using routing-key {} payload : {} " , payload);
        amqpTemplate.convertAndSend(exchange,routingKey,payload);
        log.info("published to exchange {} using routing-key {} payload : {} " , payload);
    }
}
