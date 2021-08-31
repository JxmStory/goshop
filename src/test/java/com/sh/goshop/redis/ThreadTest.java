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

    public static void main(String[] args) {
        First f = new First();
        new Thread(f).start();
        new Thread(f).start();
    }
}

class First implements Runnable {
    int i;
    public void run() {
        int i = 0;
        System.out.println(this.i++);
    }
}