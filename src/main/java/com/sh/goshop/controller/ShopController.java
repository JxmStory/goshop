package com.sh.goshop.controller;

import com.sh.goshop.common.RedisUtil;
import com.sh.goshop.common.ThreadHandle;
import com.sh.goshop.thread.MyTaskThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RequestMapping("/shop/")
@RestController
public class ShopController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ThreadHandle threadHandle;

    @PostMapping("goods")
    public String goods() {
        for (int i=0; i<10; i++) {
            redisUtil.rightPush("goodsItemId", i);
        }
        return "success";
    }


    @PostMapping("order")
    public String order(String userId){
        Random r = new Random();
        userId = r.nextInt(100) + "1";
        Object goodsItemId = redisUtil.leftPop("goodsItemId");
        if (goodsItemId != null){
            Long l = redisUtil.sSet("userId", userId);
            if (l > 0){
                System.out.println("下单成功:" + userId);
                return "下单成功";
            } else {
                System.out.println("重复购买:" + userId);
                redisUtil.rightPush("goodsItemId", goodsItemId);
                return "重复购买";
            }
        } else {
            System.out.println("库存不足:" + userId);
            return "库存不足";
        }
    }

    @GetMapping("handle")
    public Map<String, Object> handle(Integer a, String b) {
       return threadHandle.handle(new MyTaskThread(a, b));
    }

}
