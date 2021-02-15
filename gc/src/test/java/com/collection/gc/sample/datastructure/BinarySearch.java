package com.collection.gc.sample.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 이진 탐색 알고리즘
 * 선행 조건
 * - 배열에 저장된 데이터는 정렬되어있다. (ex: 1, 3, 6, 10, ... 100)
 * 
 * 요구사항
 * - 배열의 중앙에서 부터 시작하여 찾는 값이 있는지 찾으면서 크기를 비교한다.
 * - 찾는 색인 대상이 있는 경우 1 을 반환한다.
 * - 찾는 색인 대상이 없는 경우 -1 을 반환한다.
 */
public class BinarySearch {

    private int binarySearch(int[] args, int argument) {

        int firstIndex = 0;
        int lastIndex = args.length - 1;
        int middleIndex;

        // 색인 범위가 앞이 더 커진 경우 색인 실패
        // firstIndex <= middleIndex <= lastIndex
        while ( firstIndex <= lastIndex ) {

            middleIndex = (firstIndex + lastIndex) / 2;

            // 색인 완료
            if ( argument == args[middleIndex] ) {
                return 1;

            // 색인 범위 축소
            } else {
                if ( argument < args[middleIndex] ) {
                    lastIndex = middleIndex - 1;
                } else {
                    firstIndex = middleIndex + 1;
                }
            }
        }

        return -1;
    }

    @DisplayName("이진 탐색 색인 성공")
    @Test
    public void binarySearch_SearchSuccess() {
        int args[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int argument = 3;

        int expected = 1;

        assertEquals(expected, binarySearch(args, argument));
    }

    @DisplayName("이진 탐색 색인 실패")
    @Test
    public void binarySearch_SearchFail() {
        int args[] = {6, 7, 8, 10, 11, 13, 14, 15, 16, 18};
        int argument = 12;

        int expected = -1;

        assertEquals(expected, binarySearch(args, argument));
    }
}
