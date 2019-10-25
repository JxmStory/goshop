package com.sh.goshop.mq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MqProd {
    public void produce() throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("MqProd");
        producer.start();
        try {
            {
                Message message = new Message("Topic",
                        "TagA",
                        "OrderNo",
                        "2018-10-12".getBytes());
                SendResult sendResult = producer.send(message);
                System.out.println(sendResult);
            }
            {
                Message message = new Message("Topic",
                        "TagB",
                        "OrderNo",
                        "2019-08-09".getBytes());
                producer.send(message, new SendCallback() {

                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.println("success");
                    }

                    @Override
                    public void onException(Throwable e) {
                        System.out.println("exception");
                    }
                });
            }
        } catch (Exception e) {
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        producer.shutdown();
    }
}
