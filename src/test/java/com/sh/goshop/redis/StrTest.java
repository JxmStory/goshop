package com.sh.goshop.redis;

import com.sh.goshop.entity.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class StrTest {

    @Test
    public void strToInt() {
        String str = "01030";
        System.out.println(Integer.valueOf(str));
    }

    @Test
    public void InterToStr() {
        Integer i = 8;
        String ii = i + "";
        System.out.println(ii);
    }

    @Test
    public void bigdec() {
        double d = 100.0006;
        BigDecimal b = new BigDecimal(d);
//        b.setScale(2);
        b = b.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(b);
    }

    @Test
    public void shh() {
        Shh<String> shh = new Shh("shh");
        System.out.println(shh.getData());

        User user = new User();
        user.setName("abc");
        Shh<User> shhUser = new Shh(user);
        System.out.println(shhUser.getData().getName());
    }

    @Test
    public void dobb() {
        Double d = 1060.35;
        System.out.println(d*100);
        BigDecimal m = new BigDecimal(d).multiply(new BigDecimal("100"));
        System.out.println(m.setScale(0, BigDecimal.ROUND_HALF_UP));
    }

}

