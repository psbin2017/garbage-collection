package com.collection.gc.sample.datastructure.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 선택 정렬
 *
 * 1. arr[0] 과 나머지 값 비교 후 가장 작은 값과 인덱스를 찾음
 * 2. arr[0] 과 값을 스위칭
 *
 * 반복 마다 `앞의 인덱스 + 반복 횟수` 의 값이 결정된다.
 */
public class SelectionSort {
    private int[] sort(int[] arr) {

        int arrLength = arr.length;
        for ( int i = 0; i < arrLength - 1; i++ ) {
            int min = arr[i];
            int index = i;

            System.out.println("before["+i+"]::   " + Arrays.toString(arr));

            /*
             * 1. 인덱스 가장 작은 숫자를 찾음
             * 2. 현재 위치와 인덱스 위치를 바꿈
             */
            for ( int j = i + 1; j < arrLength; j++ ) {
                if ( min > arr[j] ) {
                    min = arr[j];
                    index = j;
                }
            }

            arr[index] = arr[i];
            arr[i] = min;

            System.out.println("after["+i+"]::    " + Arrays.toString(arr) + "\n");
        }
        return arr;
    }

    @DisplayName("선택 정렬")
    @Test
    public void testSelectionSort() throws Exception {
        // given
        int[] arr = new int[]{6, 7, 5, 1, 11, 3, 8};

        // when
        int[] actual = sort(arr);
        int[] expected = new int[]{1, 3, 5, 6, 7, 8, 11};

        // then
        assertArrayEquals(expected, actual);
    }
}
