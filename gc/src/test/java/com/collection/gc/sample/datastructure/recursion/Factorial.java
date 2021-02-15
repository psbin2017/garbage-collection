package com.collection.gc.sample.datastructure.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 팩토리얼
 * 요구 사항
 * - 함수 내에서 자신을 호출해야 한다.
 * - 팩토리얼 값을 반환해야 한다.
 */
public class Factorial {
    
    /**
     * n! = n * (n - 1) * (n - 2) ... 1;
     */
    private int factorial(int n) {
        if ( n == 0 ) {
            // 0 을 포함하여 탈출 조건이 됨
            return 1;
        } else {
            // 1 보다 큰 경우 자신을 재귀적으로 호출함
            return n * factorial(n - 1);
        }
    }

    @DisplayName("팩토리얼 재귀")
    @Test
    public void factorialTest() {
        int expected = 120;
        assertEquals(expected, factorial(5));
    }
}
