package com.messaging;

import com.service.MyDataService;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by m840378 on 4/12/18.
 */
@Service
public class KafkaMessageConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MyDataService myDataService;

    @Value("${kafka.topic.name}")
    private String kafkaTopic;

    @Value("${kafka.bootstrap.server}")
    private String kafkaBootstrapServer;

    private static Consumer consumer;


    public String receiveMessage() {

        if(consumer == null) {
            consumer =  createConsumer();
        }

        StringBuilder sb = new StringBuilder();

        List<String> messages = new ArrayList<String>();

        while (true) {
            final ConsumerRecords<Long, String> consumerRecords =
                    consumer.poll(1000);

            if(consumerRecords==null || consumerRecords.isEmpty()) {
                System.out.println("No messages received ");
                break;
            }

            consumerRecords.forEach(record -> {
                Object value =  record.value();
                sb.append(value);
                messages.add((String)value);
                System.out.println("Received : "+value);

            });
        }

        myDataService.saveData(messages);
        return sb.toString();
    }

    public Consumer createConsumer() {
        final Properties props = new Properties();

        //value is a comma separated list of host/port pairs that the Consumer uses
        //to establish an initial connection to the Kafka cluster.
        // Just like the producer, the consumer uses of all servers in the cluster no matter which ones we list here.
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        //props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, "range");
        // Create the consumer using props.
        final Consumer<Long, String> consumer = new KafkaConsumer<>(props);
        // Subscribe to the topic. The subscribe method takes a list of topics to subscribe to
        try{
            consumer.subscribe(Collections.singletonList(kafkaTopic));
        }catch (Exception e) {
            e.printStackTrace();
        }

        return consumer;
    }
}
