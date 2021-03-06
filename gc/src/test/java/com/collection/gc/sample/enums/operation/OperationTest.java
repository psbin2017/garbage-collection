package com.collection.gc.sample.enums.operation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

public class OperationTest {

    @Test
    public void basicOperation_test() {
        test(BasicOperation.class, 10L, 20L);
    }

    @Test
    public void basicOperation_test2() {
        test2(Arrays.asList(BasicOperation.values()), 20L, 40L);
    }

    @Test
    public void extendedOperation_test() {
        test(ExtendedOperation.class, 20L, 40L);
    }

    @Test
    public void extendedOperation_test2() {
        test2(Arrays.asList(ExtendedOperation.values()), 10L, 20L);
    }


    /**
     * <T extends Enum<T> & Operation>
     *     1. Class 객체가 열거 타입이어야한다.
     *     2. Class 객체가 Operation 의 하위 타입이어야 한다.
     *
     * @param opEnumType 한정적 타입 토큰 클래스 리터럴
     */
    private <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        System.out.println("Class Literal >> ");
        for (Operation op : opEnumType.getEnumConstants() ) {
            System.out.printf("%f %s %f = %f %n", x, op, y, op.apply(x, y));
        }
    }

    /**
     * 특정 연산에서 EnumSet 과 EnumMap 을 사용하지 못하는 단점
     *
     * @param opSet Operation 의 하위 타입의 Collection
     */
    private void test2(Collection<? extends Operation> opSet, double x, double y) {
        System.out.println("Collection >> ");
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f %n", x, op, y, op.apply(x, y));
        }
    }
}
