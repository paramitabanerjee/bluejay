package com.controller;

import com.messaging.KafkaMessageConsumer;
import com.messaging.KafkaMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by m840378 on 4/12/18.
 */

@RestController
@RequestMapping(value = "/kafkaMessageController/")
public class ApacheKafkaWebController {

    @Autowired
    KafkaMessageSender kafkaSender;

    @Autowired
    KafkaMessageConsumer kafkaConsumer;


   /* http://localhost:8180/kafkaMessageController/messageToTopic?mymessage=MyTest */

    //create a consumer: sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic javainuse-topic --from-beginning

    //try chaning this to POST request
    @GetMapping(value = "/messageToTopic")
    public String sendMessageToTopic(@RequestParam("mymessage") String message) {
        kafkaSender.send(message);

        return "Message sent to the Kafka Topic Successfully";
    }


   /*  http://localhost:8180/kafkaMessageController/getMessageFromTopic */

    @GetMapping(value = "/getMessageFromTopic")
    public String consumeMessageToTopic() {
        String receivedMessage =  kafkaConsumer.receiveMessage();

        return receivedMessage;
    }
}
