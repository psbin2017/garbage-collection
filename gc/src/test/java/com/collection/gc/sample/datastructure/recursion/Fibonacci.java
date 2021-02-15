package com.collection.gc.sample.datastructure.recursion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 피보나치 수열
 * 요구 사항
 * - 함수 내에서 자신을 호출해야 한다.
 * - 피보나치 배열을 반환해야 한다.
 */
public class Fibonacci {
    
    /**
     * 0 (DEFAULT), 1 (DEFAULT)
     * 1 (0 + 1), 2(1 + 1)
     * ...
     * n, m, n + n
     */
    private int fibnonacci(int n) {
        // System.out.println("called fibnonacci(" +n+ ")");
        if ( n == 1 ) {
            return 0;
        } else if ( n == 2 ) {
            return 1;
        }
        return fibnonacci(n - 1) + fibnonacci(n - 2);
    }

    @DisplayName("피보나치 수열 재귀")
    @Test
    public void fibonacciTest() {
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int[] actual = new int[10];

        for ( int i = 1; i < actual.length + 1; i++) {
            // System.out.println(">> start fibnonacci(" +i+ ")");
            actual[i - 1] = fibnonacci(i);
        }

        assertArrayEquals(expected, actual);
    }

}
