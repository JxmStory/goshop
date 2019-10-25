package com.sh.goshop.controller;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.sh.goshop.mq.MqProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mq/")
public class MqController {

    @Autowired
    private MqProd mqProd;

    @GetMapping("push")
    public String push(String name) throws MQClientException, InterruptedException {
        mqProd.produce();
        return name;
    }

    @PostMapping("test")
    public String test(@RequestBody Map map) {
        System.out.println(map.get("shh"));
        System.out.println("map = " + map.toString());
        return (String) map.get("chen");
    }

}
