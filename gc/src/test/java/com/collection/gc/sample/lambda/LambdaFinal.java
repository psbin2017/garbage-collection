package com.collection.gc.sample.lambda;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * @link https://vagabond95.me/posts/lambda-with-final/
 * @link https://syundev.tistory.com/246
 */
public class LambdaFinal {

    private int instanceNumber = 1;

    private static int staticNumber = 1;

    @DisplayName("람다식 지역변수 사용 불가능")
    @Test
    @Disabled
    public void testLocalVariable() throws Exception {
        // given
        int localNumber = 1;
        
        // when
        localNumber = 2;
        
        // then
        // Variable used in lambda expression should be final or effectively final
        // 람다 식에 사용되는 변수는 최종 또는 사실상 최종이어야합니다.
        // IntStream.of(localNumber).map( () ->  localNumber + 1 ).forEach(System.out::println);
    }

    @DisplayName("람다식 인스턴스 변수 사용 가능")
    @Test
    public void testInstanceVariable() throws Exception {
        // given

        // when
        instanceNumber = 2;

        // then
        IntStream.of(instanceNumber).map( e -> instanceNumber + 1).forEach(System.out::println);
    }

    @DisplayName("람다식 정적 변수 사용 가능")
    @Test
    public void testStaticVariable() throws Exception {
        // given

        // when
        staticNumber = 2;

        // then
        IntStream.of(staticNumber).map( e -> staticNumber + 1 ).forEach(System.out::println);
    }
}
