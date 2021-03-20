package com.collection.gc.sample.datastructure.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 삽입 정렬
 *
 * 1. arr[1] 과 arr[0] 비교
 * 2. arr[2] 와 arr[0 ~ 1] 비교
 * 3. arr[3] 와 arr[0 ~ 2] 비교
 *
 * ... 비교마다 temp 가 더 작다면 한 칸씩 밀어냄
 *
 * [5, 7, 9, 1] → [5, 7, 1, 9] → [5, 1, 7, 9] → [1, 5, 7, 9]
 */
public class InsertionSort {
    private int[] sort(int[] arr) {

        for (int i = 1; i < arr.length ; i++) {

            int temp = arr[i];
            int aux = i - 1;

            System.out.println("temp: " + temp + " aux: " + aux + "");

            /*
             * 인덱스 0 보다 클 때까지 색인
             * 색인 값과 대상 값 비교
             */
            while ( (aux >= 0) && ( arr[aux] > temp ) ) {
                arr[aux + 1] = arr[aux];
                aux--;

                System.out.println("arr[aux + 1]: " + arr[aux + 1] + "");
            }

            arr[aux + 1] = temp;

            System.out.println( Arrays.toString(arr) );
        }

        return arr;
    }

    @DisplayName("삽입 정렬")
    @Test
    public void testInsertionSort() throws Exception {
        // given
        int[] arr = new int[]{5, 7, 9, 1, 3, 11, 15, 13};

        // when
        int[] actual = sort(arr);
        int[] expected = new int[]{1, 3, 5, 7, 9, 11, 13, 15};

        // then
        assertArrayEquals(expected, actual);
    }
}
