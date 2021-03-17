package com.sh.goshop.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaConsumer {

    Logger logger = LoggerFactory.getLogger(MyKafkaConsumer.class);

    /**
     *  消费成功后 手动提交
     *  @author micomo
     *  @date 2021/3/16 18:47
     */
    @KafkaListener(topics = "notice_topic_1")
    public void listenTopicOne(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        double num = Math.random();
//        logger.info("【ListenTopicOne】num = {}, topic is ={}, offset is ={}, value is ={} ",
//                num, record.topic(), record.offset(), record.value());
        if (num > 0.5) {
            logger.info("name={},消费异常", JSON.parseObject((String) record.value()).getString("name"));
//            num = 1/0;
        } else {
            logger.info("name={},消费成功", JSON.parseObject((String) record.value()).getString("name"));
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = "notice_topic_2")
    public void listenTopicTwo(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        ack.acknowledge();
        logger.info("【ListenTopicTwo】topic is ={}, offset is ={}, value is ={} ", record.topic(), record.offset(), record.value());
    }
}
