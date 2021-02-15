package com.collection.gc.sample.datastructure.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 하노이타워
 * 
 * 요구사항
 * - n 개의 타워를 A 위치에서 C 로 이동한다.
 * - 이동 간, n - 1 원반은 n - 2 원반 위로 올릴 수 없다.
 */
public class HanoiTower {
    
    /**
     * 작은 원반 n - 1 를 A 에서 B 로 이동
     * 가장 큰 원반 1 개를 A 에서 C 로 이동
     * B 에 있던 원반 n - 1 개를 B 에서 C 로 이동
     * 
     * @param towerCount 원반의 개수
     * @param from 시작 이동 구역
     * @param by 거치는 곳
     * @param to 최종 이동 구역
     */
    private void hanoiTower(int towerCount, char from, char by, char to) {
        if ( towerCount == 1 ) {
            System.out.printf("원반 1. %c 에서 %c 로 이동 \n", from, to);
        } else {
            // 작은 원반 n - 1 를 A 에서 B 로 이동
            hanoiTower(towerCount - 1, from, to, by);
            System.out.printf("원반 %d. %c 에서 %c 로 이동 \n", towerCount, from, to);
            // B 에 있던 원반 n - 1 개를 B 에서 C 로 이동
            hanoiTower(towerCount - 1, by, from, to);
        }
    }
    
    private void hanoiTower(int towerCount) {
        hanoiTower(towerCount, 'A', 'B', 'C');
    }

    @DisplayName("하노이 타워")
    @Test
    public void hanoiTowerTest() {
        hanoiTower(5);
    }
}
