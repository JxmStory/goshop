package com.sh.goshop.mq;

import com.sh.goshop.common.RedisUtil;
import com.sh.goshop.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class GoodsCustomerRedis implements ApplicationRunner {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        while (true) {
            Goods goods = null;
            try {
               goods = (Goods) redisUtil.leftPop("goods", 1, TimeUnit.MINUTES);
            } catch (Exception e) {
                System.out.println("timeout exception");
            }

            if (goods != null) {
                System.out.println(goods.getName() + "---" + goods.getContent());
            } else {
                System.out.println("No data sleep 10s");
                Thread.sleep(10000);
            }
        }
    }
}
