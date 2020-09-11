package com.collection.gc.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://woowacourse.github.io/javable/2020-04-24/one-test-must-check-one-scenario
 */
public class UnitTestSample {
    
    /**
     * 현재 테스트가 통과하도록 작성되어있지만, 첫번째 테스트 케이스가 실패하면 두번째도 자동으로 실패하게 된다.
     */
    @DisplayName("나쁜 케이스: 하나의 테스트가 두개의 테스트를 수행한다.")
    @Test
    public void worthCase() {
        final int a = 10;
        final int b = 5;

        final CalculratorService calculratorService = new CalculratorService();

        final double expect = 15;
        // final double expect = 14;
        assertEquals( expect , calculratorService.plus(a, b) );

        final int c = 0;
        assertThrows( IllegalAccessException.class , () -> {
            calculratorService.divide(a, c);
        });
    }

    @DisplayName("좋은 케이스: 하나의 테스트가 하나의 테스트를 수행한다.")
    @Test
    public void bestCase() {
        final int a = 10;
        final int b = 5;

        final CalculratorService calculratorService = new CalculratorService();

        final double expect = 15;
        assertEquals( expect , calculratorService.plus(a, b) );
    }

}

class CalculratorService {

    public double plus(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) throws Exception {
        if ( b == 0 ) {
            throw new IllegalAccessException();
        }
        return a / b;
    }

}