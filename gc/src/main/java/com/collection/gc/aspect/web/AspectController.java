package com.collection.gc.aspect.web;

import com.collection.gc.aspect.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AspectController {

    private final BeforeService beforeService;

    private final AfterService afterService;

    private final AfterThrowingService afterThrowingService;

    private final AfterReturningService afterReturningService;

    private final AroundService aroundService;

    @GetMapping("/aspect/before")
    public void simpleBefore() {
        beforeService.before();
        beforeService.beforeReturnInteger();
    }

    @GetMapping("/aspect/after")
    public void simpleAfter() {
        afterService.afterReturnString("Hello World");
        afterService.afterReturnLong( 1L );
    }

    @GetMapping("/aspect/after/throwing")
    public void simpleAfterThrowing() {
        try {
            afterThrowingService.afterThrowingAspectNonAnnotation();
            afterThrowingService.afterThrowingAspectUseAnnotationRuntimeException();
            afterThrowingService.afterThrowingAspectUseAnnotationNonException();
            afterThrowingService.afterThrowingAspectUseAnnotationIllegalArgumentException();
        } catch (Exception e) {
            // skip
        }
    }

    @GetMapping("/aspect/after/returning")
    public void simpleAfterReturning() {
        try {
            afterReturningService.afterReturning("hello", 2L);
            afterReturningService.afterReturningException("world", 3L);
        } catch (Exception e) {
            // skip
        }
    }

    @GetMapping("/aspect/around")
    public void simpleAround() {
        aroundService.around();
        aroundService.around("hello", 1);
    }

}
