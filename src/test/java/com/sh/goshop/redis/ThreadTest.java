package com.sh.goshop.redis;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ThreadTest {
    @Test
    public void tett() {
        System.out.println("1111111111111");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("222222222222");
    }
}
