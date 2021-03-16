package com.sh.goshop.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyKafkaProducer {

    Logger logger = LoggerFactory.getLogger(MyKafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic.topicOne}")
    private String topicOne;
    @Value("${kafka.topic.topicTwo}")
    private String topicTwo;

    public void sendTopicOne(String name) {
        Map<String,Object> param=new HashMap<>();
        param.put("code", "one");
        param.put("name", name);
        String paramString = JSONObject.toJSONString(param);
        logger.info("发送topicOne = {}", paramString);
        //发送消息
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topicOne, paramString);

        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("kafka sendMessage error, ex = {}, topic = {}, data = {}", ex, topicOne, paramString);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                logger.info("kafka sendMessage success topic = {}, data = {}",topicOne, paramString);
            }
        });
    }

    public void sendTopicTwo(String name) {
        Map<String,Object> param=new HashMap<>(4);
        param.put("code", "two");
        param.put("name", name);
        String paramString = JSONObject.toJSONString(param);
        logger.info("发送topicTwo = {}", paramString);
        //发送消息
        kafkaTemplate.send(topicTwo, paramString);
    }
}
