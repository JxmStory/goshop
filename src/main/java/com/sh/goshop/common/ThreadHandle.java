package com.sh.goshop.common;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.*;

/**
 *  线程池提交任务
 *  @author micomo
 *  @date 2021/3/26 18:55
 */
@Component
public class ThreadHandle {

    ExecutorService pool = new ThreadPoolExecutor(
            5,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            new ThreadPoolExecutor.AbortPolicy()
    );


    @PreDestroy
    public void destroyExecutor(){
        pool.shutdown();
    }

    public Map<String, Object> handle(Callable callback) {

        Future<Map<String, Object>> result = pool.submit(callback);
        try {
            return result.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
