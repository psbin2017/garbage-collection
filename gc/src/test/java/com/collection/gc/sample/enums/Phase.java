package com.collection.gc.sample.enums;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // 상전이 맵 초기화
        private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values())
                .collect(
                        // 전이 이전 상태를 기준으로 묶는다.
                        Collectors.groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class),
                        // 전이 이후 상태를 전이에 대응시키는 EnumMap 을 생성한다.
                        // y 는 선언만 하고 소비하지 않는다.
                        // EnumMap 을 얻기 위해선 맵 팩토리가 필요하고 수집기는 점층적 팩토리(Telescoping Constructor Pattern)를 지원하기 때문이다.
                        Collectors.toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));

    }
}

class TelescopingConstructor {
    private int a;
    private String b;
    private long c;

    public TelescopingConstructor(int a) {
        this.a = a;
        this.b = "hello world";
        this.c = 1L;
    }

    public TelescopingConstructor(int a, String b) {
        this.a = a;
        this.b = b;
        this.c = 2L;
    }

    public TelescopingConstructor(int a, String b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}