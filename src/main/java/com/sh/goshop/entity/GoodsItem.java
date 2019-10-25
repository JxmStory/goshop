package com.sh.goshop.entity;

import java.io.Serializable;

public class GoodsItem implements Serializable {

    private static final long serializableID = 1L;

    private Integer id;
    private Integer goodsId;
    private String itemName;
    private String itemStock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStock() {
        return itemStock;
    }

    public void setItemStock(String itemStock) {
        this.itemStock = itemStock;
    }
}
