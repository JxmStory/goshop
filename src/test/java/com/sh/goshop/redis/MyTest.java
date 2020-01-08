package com.sh.goshop.redis;

import com.sh.goshop.entity.Abc;
import com.sh.goshop.entity.Goods;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
}
