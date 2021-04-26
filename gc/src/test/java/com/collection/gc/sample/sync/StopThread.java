package com.collection.gc.sample.sync;

import java.util.concurrent.TimeUnit;

/**
 * 이펙티브 자바 예제
 *
 * 1. 쓰기와 읽기 모두가 동기화되지 않으면 동작을 보장하지 않는다.
 *  - 읽기와 쓰기를 모두 동기화 (`synchronized`)
 *  - 가장 최근에 기록된 값을 읽게 됨을 보장 (`volatile`) ... 단, 배타적 수행과는 상관 없다.
 */
public class StopThread {

    private static boolean stopRequested;
    // private static volatile boolean stopRequested;

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
           int i = 0;
           while (!stopRequested()) {
               i++;
           }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

}
