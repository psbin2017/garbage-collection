package com.collection.gc.cache;

import com.collection.gc.cache.service.ToyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToyRunner implements CommandLineRunner {

    private final ToyService toyService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Fetch toys");
        log.info("toy 프라모델 --> " +toyService.getByTitle("프라모델"));
        log.info("toy 보드게임 --> " +toyService.getByTitle("보드게임"));
        log.info("toy 자동차 --> " +toyService.getByTitle("자동차"));
        log.info("toy RC카 --> " +toyService.getByTitle("RC카"));

        // cache
        log.info("toy 프라모델 cached --> " +toyService.getByTitle("프라모델"));
        log.info("toy 프라모델 cached --> " +toyService.getByTitle("프라모델"));
        log.info("toy 프라모델 cached --> " +toyService.getByTitle("프라모델"));
        log.info("toy 자동차 cached --> " +toyService.getByTitle("자동차"));
    }
}
