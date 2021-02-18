package com.collection.gc.aspect.service;

import com.collection.gc.aspect.annontation.AfterThrowingAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AfterThrowingService {

    public void afterThrowingAspectNonAnnotation() {
        log.info("@AfterThrowing 예외가 발생하였지만 어노테이션을 지정하지 않았다.");
        throw new IllegalArgumentException("@AfterThrowing 예외가 발생하였지만 어노테이션을 지정하지 않았다.");
    }

    @AfterThrowingAnnotation
    public void afterThrowingAspectUseAnnotationRuntimeException() {
        log.info("@AfterThrowing 어노테이션을 지정하고 RuntimeException 예외가 발생한다.");
        throw new RuntimeException("@AfterThrowing 어노테이션을 지정하고 RuntimeException 예외가 발생한다.");
    }

    @AfterThrowingAnnotation
    public void afterThrowingAspectUseAnnotationNonException() {
        log.info("@AfterThrowing 어노테이션을 지정하였지만 예외가 발생하지 않는다.");
        // non Exception
    }

    @AfterThrowingAnnotation
    public void afterThrowingAspectUseAnnotationIllegalArgumentException() {
        log.info("@AfterThrowing 어노테이션을 지정하고 IllegalArgumentException 예외가 발생한다.");
        throw new IllegalArgumentException("@AfterThrowing 어노테이션을 지정하고 IllegalArgumentException 예외가 발생한다.");
    }

}
