package com.sh.goshop.dao;

import com.sh.goshop.entity.Goods;

import java.util.List;

public interface GoodsDao {

    Integer update(Goods goods);

    Goods get(Integer id);

    Goods getByName(String name);

    List list();

    void add(Goods goods);
}
