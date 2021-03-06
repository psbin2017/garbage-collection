package com.collection.gc.sample.enums.annontation;

import java.lang.annotation.*;

/**
 * 1. `@Repeatable` 어노테이션을 반환하는 컨테이너 어노테이션을 정의하고 `@Repeatable` 에 이 컨테이너 어노테이션의 class 객체를 매개변수로 전달해야한다.
 * 2. 컨테이너 어노테이션은 내부 어노테이션 타입의 배열을 반환하는 value 메소드를 정의해야한다.
 * 3. 컨테이너 어노테이션 타입에는 적절한 보존 정책(`@Retention`)과 적용 대상(`@Target`)을 명시해야 한다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(RepeatableTestContainer.class)
public @interface RepeatableTest {
    Class<? extends Throwable> value();
}
