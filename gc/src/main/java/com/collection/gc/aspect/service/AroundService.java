package com.collection.gc.aspect.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "AroundService")
public class AroundService {

    public Long around() {
        log.info("@Around around");
        return 1L;
    }

    public void around(String stringArg, Integer integerArg) {
        log.info("@Around around");
    }

}
