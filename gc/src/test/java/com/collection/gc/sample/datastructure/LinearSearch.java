package com.collection.gc.sample.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 순차 탐색 알고리즘
 * 요구사항
 * - 맨 앞에서부터 순차적으로 탐색을 진행한다.
 * - 찾는 색인 대상이 있는 경우 1 을 반환한다.
 * - 찾는 색인 대상이 없는 경우 -1 을 반환한다.
 */
public class LinearSearch {

    private int linearSearch(int[] args, int argument) {
        for (int i : args) {
            if ( i == argument ) {
                return 1;
            }
        }
        return -1;
    }

    @DisplayName("순차 탐색 색인 성공")
    @Test
    public void linearSearch_succesSearch() {
        int args[] = {1, 2, 3, 4, 5};
        int argument = 5;

        int expected = 1;

        assertEquals(expected, linearSearch(args, argument));
    }

    @DisplayName("순차 탐색 색인 실패")
    @Test
    public void linearSearch_failSearch() {
        int args[] = {6, 7, 8, 9, 10};
        int argument = 1;

        int expected = -1;

        assertEquals(expected, linearSearch(args, argument));
    }
}