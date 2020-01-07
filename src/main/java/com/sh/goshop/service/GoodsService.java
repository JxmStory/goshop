package com.sh.goshop.service;

import com.sh.goshop.dao.GoodsDao;
import com.sh.goshop.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public void add(Goods goods) {
        goodsDao.add(goods);
    }

    public List<Goods> list() {
        return goodsDao.list();
    }
}
