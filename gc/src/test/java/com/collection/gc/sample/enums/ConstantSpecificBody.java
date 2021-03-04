package com.collection.gc.sample.enums;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ConstantSpecificBody {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    ConstantSpecificBody(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    /**
     * 동작은 하지만 깨지기 쉬운 코드.
     * 상수가 추가되면 반드시 해당 case 문도 추가되어야 한다.
     */
    /**
    public double badApply(double x, double y) {
        switch (this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES: return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("선언되지 않은 연산");
    }
    */

    // 새로운 상수가 추가되어도 추상 메소드의 구현을 잊을 수 없게 된다.
    public abstract double apply(double x, double y);

    private static final Map<String, ConstantSpecificBody> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<ConstantSpecificBody> fromString(String symbol) {
        return Optional.ofNullable( stringToEnum.get(symbol) );
    }
}