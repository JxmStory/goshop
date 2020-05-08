package com.sh.goshop.controller;

import com.sh.goshop.common.RedisUtil;
import com.sh.goshop.entity.Goods;
import com.sh.goshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String add(@RequestBody Goods goods) {
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
    public String addOrUpdate(@RequestBody Goods goods) {
        System.out.println(goods.getName()+ "" + goods.getContent());
        goodsService.add2(goods);
        return "success";
    }

    @GetMapping("insert")
    public String insert(@RequestBody Goods goods) {
        System.out.println(goods.getName()+ "" + goods.getContent());
        return goodsService.add4(goods);
    }

    @GetMapping("updateLock")
    public String updateLock(@RequestBody Goods goods) {
        System.out.println(goods.getName()+ "" + goods.getContent());
        goodsService.add6(goods);
        return "success";
    }
}
