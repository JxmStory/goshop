package com.sh.goshop.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyTaskThread implements Callable<Map<String, Object>> {

    private Integer a;
    private String b;
    Map<String, Object> map = new HashMap<>();

    public MyTaskThread(Integer a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Map<String, Object> call() {
        System.out.println("当前请求线程：" + Thread.currentThread().getName() + " 开始");
        map.put("a", String.valueOf(b));
        map.put("b", Integer.valueOf(a));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前请求线程：" + Thread.currentThread().getName() + " 结束");
        return map;
    }
}