package com.sh.goshop.controller;

import com.sh.goshop.kafka.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
