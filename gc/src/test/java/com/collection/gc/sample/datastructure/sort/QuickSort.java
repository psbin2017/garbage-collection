package com.collection.gc.sample.datastructure.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 퀵 정렬
 *
 * pivot 기준 값으로 왼쪽 | pivot | 오른쪽으로 정렬됨
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];

        // 비교 대상을 좁혀나가면서
        while (low <= high) {
            // 비교 대상보다 큰 경우 오른쪽으로 한칸이동
            while (arr[low] < pivot) {
                low++;
            }
            // 대상보다 작은 경우 왼쪽으로 한칸이동
            while (arr[high] > pivot) {
                high--;
            }
            // 선택된 대상끼리 위치 교환
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @DisplayName("퀵 정렬")
    @Test
    public void testQuickSort() throws Exception {
        // given
        int[] arr = new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7};
        quickSort(arr);

        // when
        int[] actual = arr;
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        // then
        assertArrayEquals(expected, actual);
    }
}
