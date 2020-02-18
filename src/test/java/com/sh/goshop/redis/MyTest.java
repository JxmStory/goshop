package com.sh.goshop.redis;

import com.sh.goshop.entity.Abc;
import com.sh.goshop.entity.Goods;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

@SpringBootTest
public class MyTest {

    @Test
    public void t() {
        List<String> list = Arrays.asList("a","b","","d","e");
        List<String> strs = list.stream().filter(str -> !str.isEmpty()).collect(toList());
        System.out.println(strs);
    }

    @Test
    public void tt() {
        List<Abc> list = new ArrayList<>();
        list.add(new Abc(1, "shh", "123"));
        list.add(new Abc(1, "chh", "123"));
        list.add(new Abc(1, "ccc", "123"));
        list.add(new Abc(1, "chen", "123"));
        list.add(new Abc(1, "abc", "123"));
        List<Abc> nameList = list.stream()
                .filter(abc -> abc.getUsername().startsWith("c"))
                .collect(toList());

        Iterator<Abc> iterator = nameList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getUsername());
        }
    }

    @Test
    public void ttt() {
        Goods goods = new Goods();
        goods.setName("jxm");
        String name = "SSS";
        System.out.println(goods.getName());
        System.out.println(name);
        change(goods, name);
        System.out.println(goods.getName());
        System.out.println(name);
    }

    public void change(Goods goods, String name) {
        goods.setName(goods.getName() + "!");
        name = name + "!";
    }


    /**
     * java.util 包的集合类就都是快速失败
     * 迭代器在遍历时直接访问集合中的内容，增加或删除元素时都会修改modCount变量，
     * 并抛出ConcurrentModificationException 异常
     */
    @Test
    public void failFast() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            map.put("2", "222");    // 不抛异常
            map.put("5", "55");     // 抛异常
        }
    }


    /**
     * java.util.concurrent 包下的类都是安全失败
     * 采用安全失败机制的集合容器，在遍历时不是直接在集合内容上访问的，
     * 而是先复制原有集合内容，在拷贝的集合上进行遍历。
     */
    @Test
    public void failSafe() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            map.put("2", "222");    // 不抛异常
            map.put("5", "55");     // 不抛异常
        }
    }
}
