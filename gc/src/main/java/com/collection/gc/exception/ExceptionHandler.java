package com.collection.gc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * `@RestController` 도 항상 `@ControllerAdvice` 의 대상
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    public void test(Exception e) {
        log.info("controller");
        log.info(e.getMessage());
    }

}