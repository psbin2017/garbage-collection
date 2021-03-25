package com.collection.gc.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {

    /**
     * public !!
     */
    @Async
    public void async() {
        try {
            Thread.sleep(5000);
            log.info( "current Thread name : " + Thread.currentThread().getName() );
            log.info( "current Thread group : " + Thread.currentThread().getThreadGroup() );
            log.info("async service");
        } catch (Exception e) {

        }
    }

    public void sync() {
        try {
            Thread.sleep(5000);
            log.info( "current Thread name : " + Thread.currentThread().getName() );
            log.info( "current Thread group : " + Thread.currentThread().getThreadGroup() );
            log.info("sync service");
        } catch (Exception e) {

        }
    }
}
