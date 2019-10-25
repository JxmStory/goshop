package com.sh.goshop.redis;

import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class TemplateTest {

    private static String URL = "http://182.48.111.68:8040/api/m-borrowmoney-outreach/app/user!jqdCheck.action";
    @Test
    public void postTemplate() {

        RestTemplate rt = new RestTemplate();
        ((SimpleClientHttpRequestFactory)rt.getRequestFactory()).setReadTimeout(3000);
        ((SimpleClientHttpRequestFactory)rt.getRequestFactory()).setConnectTimeout(500);

        MultiValueMap<String, Object> blackMap = new LinkedMultiValueMap<>();
        blackMap.add("channelCode", "JDH");
        blackMap.add("idnum", "11010519780605031X");
        blackMap.add("phone", "13772000038");

        System.out.println("StartTime="
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String blackReturn = rt.postForObject(URL, blackMap, String.class);
        System.out.println("EndTime="
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println(blackReturn);
    }
}
