package com.sh.goshop.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {

    Logger logger = LoggerFactory.getLogger(MyKafkaConsumer.class);

    @KafkaListener(topics = "notice_topic_1")
    public void listenTopicOne(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        double num = Math.random();
        logger.info("【ListenTopicOne】num = {}, topic is ={}, offset is ={}, value is ={} ",
                num, record.topic(), record.offset(), record.value());
        if (num > 0.5) {
            num = 1/0;
        }
        ack.acknowledge();
    }


    @KafkaListener(topics = "notice_topic_2")
    public void listenTopicTwo(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        ack.acknowledge();
        logger.info("【ListenTopicTwo】topic is ={}, offset is ={}, value is ={} ", record.topic(), record.offset(), record.value());
    }
}
