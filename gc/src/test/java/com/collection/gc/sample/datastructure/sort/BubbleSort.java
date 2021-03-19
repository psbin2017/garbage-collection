package com.collection.gc.sample.datastructure.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 버블 정렬
 *
 * 1. arr[0] 과 arr[1] 비교
 * 2. arr[1] 이 작으면 arr[0] 값과 스위칭 ... 인덱스 끝까지 진행 (arr[1] diff arr[2] ...)
 *
 * 반복 마다 `마지막 인덱스 - 반복 횟수` 의 값이 결정 된다.
 */
public class BubbleSort {
    private int[] sort(int[] arr) {

        int arrLength = arr.length;
        for ( int i = 0; i < arrLength; i++ ) {

            System.out.println("before["+i+"]::   " + Arrays.toString(arr));

            /*
             * `j < arrLength - i - 1`
             * - 색인 범위가 반복 횟수마다 감소한다. (매번 반복마다 마지막 인덱스의 값이 결정되기 때문이다.)
             */
            for ( int j = 0; j < arrLength - i - 1; j++ ) {
                if ( arr[j] > arr[j + 1] ) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("after["+i+"]::    " + Arrays.toString(arr) + "\n");
        }
        return arr;
    }

    @DisplayName("버블 정렬")
    @Test
    public void testBubbleSort() throws Exception {
        // given
        int[] arr = new int[]{6, 3, 10, 5, 1, 8};

        // when
        int[] actual = sort(arr);
        int[] expected = new int[]{1, 3, 5, 6, 8, 10};

        // then
        assertArrayEquals(expected, actual);
    }
}
