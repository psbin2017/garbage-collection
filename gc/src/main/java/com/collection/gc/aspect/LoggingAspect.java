package com.collection.gc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    /**
     * `@Before`
     * - 타겟의 실행 전 어드바이스 메소드가 실행된다.
     * <p>
     * execution
     * - 메소드 대상
     * <p>
     * - 반환 타입과 관계 없이 모든 대상
     * <p>
     * com.collection.gc.aspect.service..
     * - 해당 패키지로 시작하는 모든 패키지 선택
     * <p>
     * *Service
     * - 클래스 명이 Service 로 끝나는 클래스 선택
     * <p>
     * before*(..)
     * - 메소드 명이 before 로 시작하는 메소드 선택
     */
    @Before("execution(* com.collection.gc.aspect.service..*Service.before*())")
    public void beforeLoggingUseExecution(JoinPoint joinPoint) {
        showJoinPoint(joinPoint, "@Before beforeLoggingUseExecution");
    }

    /**
     * `@After`
     * - 타겟의 실행 후 어드바이스 메소드가 실행된다.
     * <p>
     * within
     * - 메서드가 아닌 특정 타입에 속하는 대상
     * <p>
     * com.collection.gc.aspect.service.AfterAspectService
     * - 대상 클래스 지정
     */
    @After("within(com.collection.gc.aspect.service.AfterService)")
    public void afterLoggingUseWithin(JoinPoint joinPoint) {
        showJoinPoint(joinPoint, "@After afterLoggingUseWithin");
    }

    /**
     * `@AfterThrowing`
     * - 타겟이 실행 후 예외가 발생하면 어드바이스 메소드가 실행된다.
     * <p>
     * `@annotation`
     * - 해당 어노테이션이 메소드에 선언되어있는 대상
     * <p>
     * `throwing`
     * - 발생한 예외를 가져올 수 있다.
     */
    @AfterThrowing(value = "@annotation(com.collection.gc.aspect.annontation.AfterThrowingAnnotation)", throwing = "ex")
    public void afterThrowingUseAnnotation(JoinPoint joinPoint, Throwable ex) {
        log.info("---------- @AfterThrowing afterThrowingUseAnnotation start ----------");
        log.info(" ex.getMessage : {}", ex.getMessage() );
        // log.info(" ex.getStackTrace : {}", ex.getStackTrace() );
        log.info("---------- @AfterThrowing afterThrowingUseAnnotation end ----------");
    }

    /**
     * `@AfterReturning`
     * - 타겟이 정상 실행 후 어드바이스 메소드가 실행된다.
     * <p>
     * this(AfterReturningService)
     * - this instanceof AfterReturningService == true 인 경우인 대상
     */
    @AfterReturning("this(com.collection.gc.aspect.service.AfterReturningService)")
    public void afterReturningUseThis(JoinPoint joinPoint) {
        showJoinPoint(joinPoint, "@AfterReturning afterReturningUseTarget");
    }

    /**
     * `@Around`
     * - 타겟을 감싼다. 어드바이스 메소드가 실행되고 → 타겟 메소드를 실행하고 → 남은 어드바이스 메소드가 실행된다.
     * <p>
     * bean(Around*)
     * - Around 로 시작하는 빈이 대상.
     */
    @Around("bean(Around*)")
    public Object aroundUseBean(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("@Around aroundUseBean");
        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            stopWatch.stop();
            showJoinPoint(proceedingJoinPoint, "@Around aroundUseBean");
            log.info( stopWatch.prettyPrint() );
        }
    }

    private void showJoinPoint(JoinPoint joinPoint, String methodName) {
        log.info("---------- {} start ----------", methodName);

        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();

        log.info("타겟 메소드 시그니쳐 : " + signature.toString());
        log.info("타겟 클래스 : " + target.toString());
        log.info("타겟 메소드 : " + signature.getName());

        for (int i = 0; i < args.length; i++) {
            log.info("타겟 메소드의 인자 값 [" + i + "] : " + args[i].toString());
        }

        log.info("---------- {} end ----------", methodName);
    }
}
