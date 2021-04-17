package com.course.kafka.broker.consumer;

import com.course.kafka.broker.message.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer
{
    @KafkaListener(topics = "t.commodity.order")
    public void consume(OrderMessage message)
    {
        int totalAmount = message.getPrice() * message.getQuantity();
        log.info("Consumed OrderMessage: {}, totalAmount of the order: {}", message, totalAmount);
    }
}
