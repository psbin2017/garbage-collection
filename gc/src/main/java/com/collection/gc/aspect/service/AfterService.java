package com.collection.gc.aspect.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AfterService {

    public String afterReturnString(String arg) {
        log.info("afterReturnString 해당 로그 출력 후 Aspect 가 출력된다.");
        return arg;
    }

    public Long afterReturnLong(Long arg) {
        log.info("afterReturnLong 해당 로그 출력 후 Aspect 가 출력된다.");
        return arg;
    }
}
