package com.collection.gc.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 풀 초기화시 기본 갯수
        executor.setCorePoolSize(2);

        // 풀 동적 최대 갯수
        executor.setMaxPoolSize(10);

        // 큐 최대 갯수
        executor.setQueueCapacity(1000);

        // 스레드 프리픽스 지정
        executor.setThreadNamePrefix("async-thread-");

        executor.initialize();
        return executor;
    }
}
