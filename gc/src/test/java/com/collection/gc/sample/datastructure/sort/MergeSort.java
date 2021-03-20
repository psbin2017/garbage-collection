package com.collection.gc.sample.datastructure.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 병합 정렬
 *
 * 1. 분할 (배열을 가장 작은 단위인 1개까지 분할)
 * 2. 정복 (나누어진 배열을 결합하면서 비교)
 */
public class MergeSort {

    int[] arr;

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int left, int right) {
        // 분할가능한 엘리먼트가 2개 이상일 때
        if ( right - left < 2 ) {
            return;
        }
        int middle = (left + right) / 2;

        // step 분할
        sort(arr, left, middle);
        sort(arr, middle, right);

        // step 정복
        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left];
        int t = 0;
        int l = left;
        int h = middle;

        while (l < middle && h < right) {
            if (arr[l] < arr[h]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[h++];
            }
        }

        while (l < middle) {
            temp[t++] = arr[l++];
        }

        while (h < right) {
            temp[t++] = arr[h++];
        }

        for (int i = left; i < right; i++) {
            arr[i] = temp[i - left];
        }
    }

    @DisplayName("병합 정렬")
    @Test
    public void testMergeSort() throws Exception {
        // given
        arr = new int[]{4, 2, 3, 1};
        sort(arr);

        // when
        int[] actual = arr;
        int[] expected = new int[]{1, 2, 3, 4};

        // then
        assertArrayEquals(expected, actual);
    }
}
