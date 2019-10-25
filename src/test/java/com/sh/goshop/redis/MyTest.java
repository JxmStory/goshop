package com.sh.goshop.redis;

import com.sh.goshop.entity.Abc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MyTest {

    @Test
    public void teset() {
        List<String> list = Arrays.asList("a","b","","d","e");
        List<String> strs = list.stream().filter(str -> !str.isEmpty()).collect(toList());
        System.out.println(strs);
    }

    @Test
    public void ttt() {
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
}
