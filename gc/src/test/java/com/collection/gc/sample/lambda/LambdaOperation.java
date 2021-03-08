package com.collection.gc.sample.lambda;

import java.util.function.DoubleBinaryOperator;

/**
 * @see com.collection.gc.sample.enums.operation.BasicOperation;
 */
public enum LambdaOperation {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;

    // Double 타입 인수 2개를 받아 Double 타입 결과를 반환
    private final DoubleBinaryOperator op;

    LambdaOperation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
