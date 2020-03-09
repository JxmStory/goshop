package com.sh.goshop.controller;

import com.sh.goshop.common.RedisUtil;
import com.sh.goshop.entity.Goods;
import com.sh.goshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("add")
    public String add(Goods goods) {
        goodsService.add(goods);
        return "success";
    }

    @GetMapping("list")
    public List<Goods> list() {
        return goodsService.list();
    }

    @GetMapping("produce")
    public String produce() {
        List<Goods> goods = goodsService.list();
        goods.forEach(good -> redisUtil.rightPush("goods", good));
        return "success";
    }


    @GetMapping("addOrUpdate")
    public String addOrUpdate(Goods goods) {
        System.out.println(goods.getName()+ "" + goods.getContent());
        goodsService.addOrUpdate(goods);
        return "success";
    }

    @GetMapping("insert")
    public String insert(Goods goods) {
        System.out.println(goods.getName()+ "" + goods.getContent());
        return goodsService.insert(goods);
    }
}
