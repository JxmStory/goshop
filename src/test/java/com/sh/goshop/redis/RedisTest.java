package com.sh.goshop.redis;

import com.sh.goshop.common.RedisUtil;
import com.sh.goshop.entity.Abc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("study", "java");
        System.out.println(redisTemplate.opsForValue().get("study"));
        Abc abc = new Abc();
        abc.setAccount("123456");
        abc.setArea("henan");
        abc.setId(2);
        abc.setUsername("jxm");
        redisTemplate.opsForValue().set("study", abc);
        System.out.println(redisTemplate.opsForValue().get("study"));
        redisUtil.expire("study", 20);
        if (redisUtil.get("study") == null) {
            System.out.println("aaa");
        }
    }


    @Test
    public void test1() {
        List list = new ArrayList();
        list.add("hhh");
        list.add(2);
        list.add("sfa");
//        redisTemplate.opsForList().rightPush("name", list);

        List list1 = redisTemplate.opsForList().range("name", 0, redisTemplate.opsForList().size("name"));
        Iterator i = list1.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}