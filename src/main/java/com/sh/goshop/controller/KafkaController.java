package com.sh.goshop.controller;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.sh.goshop.kafka.MyKafkaProducer;
import com.sh.goshop.mq.MqProd;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/kfk/")
public class KafkaController {

    @Autowired
    private MyKafkaProducer producer;

    @GetMapping("sendOne")
    public String sendOne(String name) {
        producer.sendTopicOne(name);
        return "Success-One";
    }

    @GetMapping("sendTwo")
    public String sendTwo(String name) {
        producer.sendTopicTwo(name);
        return "Success-Two";
    }

}
