package com.sh.goshop.mq;

import com.alibaba.rocketmq.client.exception.MQClientException;

public class Starter implements Runnable {

    private MqProd mqProd;

    public Starter(MqProd mqProd) {
        this.mqProd = mqProd;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 30) {
            i++;
            try {
                mqProd.produce();
                Thread.sleep(3000);
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
