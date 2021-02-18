package com.collection.gc.aspect.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class BeforeService {

    @PostConstruct
    public void init() {
        // 프록시 기반의 스프링 AOP 는 @PostConstruct 를 인식하지 못한다.
        // https://stackoverflow.com/questions/34632051/spring-aop-and-post-construct
        this.before();
    }

    public void before() {
        log.info("before 해당 로그 출력 전 Aspect 가 출력된다.");
    }

    public int beforeReturnInteger() {
        log.info("beforeReturnInteger 해당 로그 출력 전 Aspect 가 출력된다.");
        return 1;
    }

}
