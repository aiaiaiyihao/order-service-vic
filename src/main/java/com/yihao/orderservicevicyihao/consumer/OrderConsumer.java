package com.yihao.orderservicevicyihao.consumer;

import com.yihao.orderservicevicyihao.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "order-created", groupId = "order-group")
    public void consume(OrderCreatedEvent event) {
        log.info("Received Kafka message from topic order-created: {}", event);
    }
}