package com.collection.gc.aspect.service.impl;

import com.collection.gc.aspect.service.AfterReturningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AfterReturningServiceImpl implements AfterReturningService {

    @Override
    public void afterReturningException(String stringArg, Long longArg) {
        log.info("@AfterReturning 대상이지만 예외가 발생하여 Aspect 를 실행하지 않는다.");
        throw new IllegalArgumentException("@AfterReturning target but Exception");
    }

    @Override
    public void afterReturning(String stringArg, Long longArg) {
        log.info("@AfterReturning 대상으로 정상 처리되어 Aspect 를 실행 한다.");
    }
}
