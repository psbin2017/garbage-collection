package com.collection.gc.aspect.web;

import com.collection.gc.aspect.service.*;
import com.collection.gc.aspect.service.impl.AfterReturningServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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

    @GetMapping("/aspect/proxy")
    public void proxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(AfterReturningService.class);
        proxyFactory.setTarget(new AfterReturningServiceImpl());
        final AfterReturningService jdkDynamicProxy = (AfterReturningService) proxyFactory.getProxy();
        /*
         * JDK 동적 프록시 proxy.getClass() : class com.sun.proxy.$Proxy78
         * 인터페이스가 있어서 JDK 동적 프록시로 주입되어 생성되었다.
         */
        log.info( "proxy.getClass() : " + jdkDynamicProxy.getClass());


        ProxyFactory proxyFactory2 = new ProxyFactory();
        proxyFactory2.setTarget(new AroundService());
        final AroundService cglibProxy = (AroundService) proxyFactory2.getProxy();
        /*
         * CGLIB 프록시 proxy.getClass() : class com.collection.gc.aspect.service.AroundService$$EnhancerBySpringCGLIB$$306616bc
         * 인터페이스가 없어서 CGLIB 프록시로 주입되어 생성되었다.
         */
        log.info( "proxy.getClass() : " + cglibProxy.getClass());
    }

}
