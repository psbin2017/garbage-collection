package com.collection.gc.sample.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

/**
 * https://jojoldu.tistory.com/58?category=635881
 */
public class StringAppendSample {

    private final int LOOP_SIZE = 1000;

    @DisplayName("한 라인에 문자열을 더한다")
    @Test
    public void test_appendOneLine() {
        StopWatch sw = new StopWatch("한 라인에 문자열을 더한다");

        sw.start();
        String s = null;
        for ( int i = 0; i < LOOP_SIZE; i++) {
            s = "hello" + "." + "world";
        }
        sw.stop();

        System.out.println( sw.prettyPrint() );
        System.out.println( s );
    }

    /**
     * 여러 개의 라인으로 처리를 하는 경우, StringBuilder 가 사용되지 않음
     */
    @DisplayName("여러 라인에 문자열을 더한다")
    @Test
    public void test_appendMultiLine() {
        StopWatch sw = new StopWatch("여러 라인에 문자열을 더한다");

        sw.start();
        String s = null;
        for ( int i = 0; i < LOOP_SIZE; i++) {
            s = "hello"; // new StringBuilder("hello").toString();
            s += "."; //  new StringBuilder(".").toString();
            s += "world"; // new StringBuilder("world").toString();
        }
        sw.stop();

        System.out.println( sw.prettyPrint() );
        System.out.println( s );
    }
}