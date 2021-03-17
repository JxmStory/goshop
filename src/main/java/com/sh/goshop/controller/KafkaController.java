package com.sh.goshop.controller;

import com.sh.goshop.kafka.MyKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Scope("prototype") Spring的controller默认是单例 声明为prototype则为多例
@RestController
@RequestMapping("/kfk/")
public class KafkaController {

    @Autowired
    private MyKafkaProducer producer;

    private Integer num = 1;

    @GetMapping("sendOne")
    public String sendOne(String name) {
        producer.sendTopicOne(num++ + "");
        return "Success-One";
    }

    @GetMapping("sendTwo")
    public String sendTwo(String name) {
        producer.sendTopicTwo(name);
        return "Success-Two";
    }

}
