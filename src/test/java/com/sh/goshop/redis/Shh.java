package com.sh.goshop.redis;

public class Shh <T> {

    private T data;

    Shh() {

    }
    Shh(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

}
