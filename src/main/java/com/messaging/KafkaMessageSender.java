package com.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by m840378 on 4/12/18.
 */

@Service
public class KafkaMessageSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String kafkaTopic;

    public void send(String message) {

        kafkaTemplate.send(kafkaTopic, message);
        System.out.println("Message sent : "+ message);
    }
}
