package com.sh.goshop.service;

import com.sh.goshop.dao.GoodsDao;
import com.sh.goshop.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Semaphore;

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

    /**
     * 使用事务不能解决并发问题
     * 依然可以同时读到数据库记录为空
     */
    @Transactional
    public void update(Goods goods) {
        Goods gd = goodsDao.getByName(goods.getName());
        if (gd == null) {
            goodsDao.add(goods);
        }
    }


    /**
     * 使用同步方法解决并发
     * 注意：@Transactional注解会使synchronize失效
     *      集群下synchronize也会失效 synchronize只针对本地jvm
     */
    public synchronized void addOrUpdate(Goods goods) {
        Goods gd = goodsDao.getByName(goods.getName());
        if (gd == null) {
            goodsDao.add(goods);
        }
    }

    /**
     * 使用信号量
     */
    Semaphore semaphore = new Semaphore(1);  //定义资源的总数量
    public String insert(Goods goods) {
        int availablePermits = semaphore.availablePermits();//可用资源数
        if(availablePermits>0){
            System.out.println("抢到资源");
        }else{
            System.out.println("资源已被占用，稍后再试");
            return "Resource is busy！";
        }
        try {
            semaphore.acquire(1);  //请求占用一个资源
            System.out.println("资源正在被使用");
            Goods gd = goodsDao.getByName(goods.getName());
            if (gd == null) {
                goodsDao.add(goods);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semaphore.release(1);//释放一个资源
        }
        return "Success";
    }
}
