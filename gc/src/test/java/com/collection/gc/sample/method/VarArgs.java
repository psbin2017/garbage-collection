package com.collection.gc.sample.method;

public class VarArgs {

    /**
     * 인수가 1개 이상이어야 할 때 가변인수를 활용하는 방법
     *
     * firstArg 를 통해 인수 하나를 강제한다.
     */
    public static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            min = Math.min(min, arg);
        }
        return min;
    }
}
